import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1767 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}

	static int[][] map;
	static ArrayList<Pos> core;
	static boolean[] visitedCore;
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ansSel;
	static int Ans;

	static void dfs(int x, int y, int cnt, int depth, int sel) {
		int wire = 0;
		for (int i = 0; i < 4; i++) {
			int dist = 1;
			boolean isValid = true;
			int nx;
			int ny;

			while (true) {
				nx = x + dx[i] * dist;
				ny = y + dy[i] * dist;

				if (nx >= N || nx < 0 || ny >= N || ny < 0) {
					nx -= dx[i];
					ny -= dy[i];
					wire = dist - 1;
					break;
				}

				if (map[nx][ny] == 1) {
					isValid = false;
					break;
				}
				dist++;
			}
			if (!isValid)
				continue;
			
			for (int j = 0; j < dist - 1; j++) {
				map[nx][ny] = 1;
				nx -= dx[i];
				ny -= dy[i];
			}

			if(depth + 1 < core.size()) { 
				dfs(core.get(depth + 1).x, core.get(depth + 1).y, cnt + wire, depth + 1, sel + 1);
			}

			for (int j = 0; j < dist - 1; j++) {
				nx += dx[i];
				ny += dy[i];
				map[nx][ny] = 0;
			}

			if (depth == core.size() - 1) {
				if (ansSel < sel) {
					ansSel = sel;
					Ans = cnt + wire;
				} else if (ansSel == sel) {
					Ans = Math.min(Ans, cnt + wire);
				}
			}
		}
		if(depth + 1 < core.size()) {
			dfs(core.get(depth + 1).x, core.get(depth + 1).y, cnt, depth + 1, sel);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			core = new ArrayList<>();
			Ans = Integer.MAX_VALUE;
			ansSel = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 1 && !(j == 0 || j == N - 1 || i == 0 || i == N - 1)) {
						core.add(new Pos(i, j));
					}
					map[i][j] = input;
				}
			}
			visitedCore = new boolean[core.size()];
			visitedCore[0] = true;
			dfs(core.get(0).x, core.get(0).y, 0, 0, 0);
			System.out.println("#" + tc + " " + Ans);
		}
	}
}