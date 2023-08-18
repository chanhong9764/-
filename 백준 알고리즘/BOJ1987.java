import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1987 {
	static class Pos {
		int x;
		int y;
		int dist;
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return this.x + " " + this.y ;
		}
		@Override
		public boolean equals(Object obj) {
			return (this.x == ((Pos)obj).x && this.y == ((Pos)obj).y);
		}
	}
	static char[][] map;
	static Set<Character> visited = new HashSet<Character>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C, ans;
	
	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= R || nx < 0 || ny >= C || ny < 0 || visited.contains(map[nx][ny])) {
				continue;
			}
			visited.add(map[nx][ny]);
			dfs(nx, ny, cnt + 1);
			visited.remove(map[nx][ny]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		visited.add(map[0][0]);
		dfs(0, 0, 1);
		System.out.println(ans);
	}
}
