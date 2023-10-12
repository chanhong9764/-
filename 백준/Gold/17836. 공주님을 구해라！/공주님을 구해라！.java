import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x, y, dist;

		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static int N, M, T;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Pos sword;

	static int bfs(int x, int y) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, 0));
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			if(t.x == x && t.y == y) {
				return t.dist;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny] || map[nx][ny] == 1) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Pos(nx, ny, t.dist + 1));
			}
		}
		
		return 0;
	}
	
	static int bfs2(int x, int y, int dist) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(x, y, dist));
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			if(t.x == N - 1 && t.y == M - 1) {
				return t.dist;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Pos(nx, ny, t.dist + 1));
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 2) {
					sword = new Pos(i, j, 0);
				}
				map[i][j] = input;
			}
		}

		visited = new boolean[N][M];
		int notEat = bfs(N - 1, M - 1);
		visited = new boolean[N][M];
		int swordDist = bfs(sword.x, sword.y);
		
		if(swordDist == 0) {
			if(notEat == 0) {
				System.out.println("Fail");
			} else {
				if(notEat > T) {
					System.out.println("Fail");
				} else {
					System.out.println(notEat);
				}
			}
		} else {
			visited = new boolean[N][M];
			int Ans = bfs2(sword.x, sword.y ,swordDist);
			
			if(notEat == 0) {
				if(Ans > T) {
					System.out.println("Fail");
				} else {
					System.out.println(Ans);
				}
			} else {
				if(notEat > Ans) {
					if(Ans > T) {
						System.out.println("Fail");
					} else {
						System.out.println(Ans);
					}
				} else {
					if(notEat > T) {
						System.out.println("Fail");
					} else {
						System.out.println(notEat);
					}
				}
			}
		}
	}

}
