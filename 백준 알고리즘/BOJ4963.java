import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
	static int[][] map;
	static int w, h;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int ans;
	
	static void dfs(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= h || nx < 0 || ny >= w || ny < 0 || visited[nx][ny]) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			ans = 0;
			
			if(w == 0 && h == 0) break;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 0) {
						visited[i][j] = true;
					}
					map[i][j] = input;
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

}
