import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17136 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			return (((Pos) obj).x == this.x && ((Pos) obj).y == this.y);
		}
	}

	static int[][] map = new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static ArrayList<Pos> position = new ArrayList<Pos>();
	static boolean[] qVistied;
	static int ans = Integer.MAX_VALUE;

	static void dfs(int cnt) {
		if (cnt >= position.size()) {
			int total = 0;
			for (int i = 1; i <= 5; i++) {
				total += 5 - paper[i];
			}
			ans = Math.min(ans, total);
			return;
		}
		if (qVistied[cnt]) {
			dfs(cnt + 1);
		}
		Pos t = position.get(cnt);

		for (int i = 1; i <= 5; i++) {
			if (isValid(t.x, t.y, i) && paper[i] > 0) {
				adtach(t.x, t.y, i, true);
				paper[i]--;
				dfs(cnt + 1);
				adtach(t.x, t.y, i, false);
				paper[i]++;
			}
		}
	}

	static boolean isValid(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= 10 || i < 0 || j >= 10 || j < 0 || map[i][j] == 0 || visited[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void adtach(int x, int y, int size, boolean type) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				visited[i][j] = type;
				qVistied[position.indexOf(new Pos(i, j))] = type;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					position.add(new Pos(i, j));
				}
			}
		}

		if (position.size() != 0) {
			qVistied = new boolean[position.size()];
			dfs(0);
			if(ans == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(ans);
			}
		} else {
			System.out.println(0);
		}

	}
}
