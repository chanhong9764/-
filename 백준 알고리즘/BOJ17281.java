import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17281 {
	static int[][] baseball;
	static boolean[] visited;
	static int[] sel;
	static int maxScore = Integer.MIN_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		baseball = new int[N][9];
		visited = new boolean[8];
		sel = new int[9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				baseball[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(0);

		System.out.println(maxScore);
	}

	static int getScore() {
		int score = 0;
		int pos = -1;
		
		for (int i = 0; i < N; i++) {
			int out = 0;
			ArrayList<Integer> roo = new ArrayList<>();
			while (true) {
				pos = ++pos % 9;
				int curData = baseball[i][sel[pos]];

				if (curData == 0) {
					out++;
					if (out == 3)
						break;
					continue;
				}

				for (int j = 0; j < roo.size(); j++) {
					int base = roo.get(j);
					if (base + curData >= 4) {
						score++;
						roo.remove(j--);
					} else {
						roo.set(j, curData + base);
					}
				}

				if (curData == 4) {
					score++;
					continue;
				}
				roo.add(curData);
			}
		}
		return score;
	}

	static void recursive(int depth) {
		if (depth == 9) {
			maxScore = Math.max(maxScore, getScore());
			return;
		}

		if (depth == 3) {
			sel[depth] = 0;
			recursive(depth + 1);
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[depth] = i + 1;
				recursive(depth + 1);
				visited[i] = false;
			}
		}
	}
}
