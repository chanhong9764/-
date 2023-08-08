import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA7733 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int[][] cheese;
	static boolean[][] visited;
	static int N;
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y, int day) {
		ArrayDeque<Pos> q = new ArrayDeque<Pos>();
		q.add(new Pos(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx >= N || nx < 0 || ny >= N || ny < 0 || cheese[nx][ny] <= day || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Pos(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			int maxTaste = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int taste = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(maxTaste, taste);
					cheese[i][j] = taste;
				}
			}
			
			for(int i = 0; i <= maxTaste; i++) {
				visited = new boolean[N][N];
				int count = 0;
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						if(!visited[j][k] && cheese[j][k] > i) {
							bfs(j, k, i);
							count++;
						}
					}
				}
				ans = Math.max(ans, count);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
