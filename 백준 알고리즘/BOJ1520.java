import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1520 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int dfs(int x, int y) {
		if(x == N - 1 && y == M - 1) {
			return 1;
		}
		dp[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny] || map[x][y] <= map[nx][ny] || dp[nx][ny] == 0) {
				continue;
			}
			if(dp[nx][ny] != -1) {
				dp[x][y] += dp[nx][ny];
			} else {
				visited[nx][ny] = true;
				dp[x][y] += dfs(nx, ny);
				visited[nx][ny] = false;
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = true;
		dfs(0, 0);
		
		System.out.println(dp[0][0]);
	}
}
