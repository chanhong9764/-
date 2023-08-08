import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1949 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int maxValue, N, K;
	static Queue<Pos> height;
	static boolean[][] visited;
	static boolean isValidConstruction;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans;

	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
				continue;
			}

			if (map[nx][ny] >= map[x][y]) {
				if (isValidConstruction) {
					isValidConstruction = false;
					for (int j = 1; j <= K; j++) {
						map[nx][ny] -= j;
						if (map[nx][ny] < map[x][y]) {
							visited[nx][ny] = true;
							dfs(nx, ny, cnt + 1);
							visited[nx][ny] = false;
						}
						map[nx][ny] += j;
					}
					isValidConstruction = true;
				}
			} else {
				visited[nx][ny] = true;
				dfs(nx, ny, cnt + 1);
				visited[nx][ny] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			maxValue = 0;
			height = new LinkedList<Pos>();
			isValidConstruction = true;
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (maxValue < input) {
						maxValue = input;
						height.clear();
						height.add(new Pos(i, j));
					} else if (maxValue == input) {
						height.add(new Pos(i, j));
					}
					map[i][j] = input;
				}
			}
			while (!height.isEmpty()) {
				Pos p = height.poll();
				visited[p.x][p.y] = true;
				dfs(p.x, p.y, 1);
				visited[p.x][p.y] = false;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
