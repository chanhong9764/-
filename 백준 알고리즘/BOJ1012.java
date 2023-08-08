import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ1012 {
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] ground;
	static int M, N;
	static ArrayDeque<Pos> ps;
	static int ans;
	
	public static void bfs(int x, int y) {
		ArrayDeque<Pos> q = new ArrayDeque<Pos>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= M || nx < 0 || ny >= N || ny < 0 || ground[nx][ny] == 0) { 
					continue;
				}
				ground[nx][ny] = 0;
				q.add(new Pos(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ground = new int[M][N];
			ps = new ArrayDeque<Pos>();
			ans = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int tx = Integer.parseInt(st.nextToken());
				int ty = Integer.parseInt(st.nextToken());
				ps.add(new Pos(tx, ty));
				ground[tx][ty] = 1;
			}
			while(!ps.isEmpty()) {
				Pos p = ps.poll();
				if(ground[p.x][p.y] == 0) continue;
				bfs(p.x, p.y);
				ans++;
			}
			System.out.println(ans);
		}
	}
}
