import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA7699 {
	static char[][] map;
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Character> temp;
	static int ans;
	
	public static void dfs(int x, int y, int step) {
		ans = Math.max(ans, step);
		temp.add(map[x][y]);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= R || nx < 0 || ny >= C || ny < 0 || temp.contains(map[nx][ny])) {
				continue;
			}
			dfs(nx, ny, step + 1);
		}
		temp.remove(temp.indexOf(map[x][y]));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			temp = new ArrayList<>();
			ans = 0;
			
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			dfs(0, 0, 1);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
