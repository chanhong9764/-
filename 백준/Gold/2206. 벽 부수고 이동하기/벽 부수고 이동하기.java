import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x, y;
		int dist;
		int count;
		public Pos(int x, int y, int count, int dist) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dist = dist;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][][] visited;
	static int Ans = Integer.MAX_VALUE;
	
	static void bfs() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos t = q.poll();

			if(t.x == N - 1 && t.y == M - 1) {
				Ans = Math.min(Ans, t.dist + 1);
				continue;
			}

			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
					
				if(nx >= N || nx < 0 || ny >= M || ny < 0) {
					continue;
				}
				if(t.count == 0) {
					if(map[nx][ny] == 0 && !visited[0][nx][ny]) {
						visited[0][nx][ny] = true;
						q.add(new Pos(nx, ny, t.count, t.dist + 1));
					}
					if(map[nx][ny] == 1 && !visited[1][nx][ny]){
						visited[1][nx][ny] = true;
						q.add(new Pos(nx, ny, t.count + 1, t.dist + 1));
					}
				} else {
					if(map[nx][ny] == 0 && !visited[1][nx][ny]) {
						visited[1][nx][ny] = true;
						q.add(new Pos(nx, ny, t.count, t.dist + 1));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[2][N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		bfs();
		if(Ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Ans);
		}
	}
	
	static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
