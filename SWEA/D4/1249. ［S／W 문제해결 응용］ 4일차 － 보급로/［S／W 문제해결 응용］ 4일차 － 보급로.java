import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	static class Pos implements Comparable<Pos>{
		int x, y, dist;
		
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	static int[][] map;
	static int N, Ans;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void bfs() {
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(0, 0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			if(t.x == N - 1 && t.y == N - 1) {
				Ans = t.dist;
				return;
			}

			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Pos(nx, ny, t.dist + map[nx][ny]));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			Ans = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			bfs();
			System.out.println("#" + tc + " " + Ans);
		}
	}
}
