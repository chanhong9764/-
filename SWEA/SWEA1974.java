import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1974 {
	static int[][] map;

	static boolean RowCol() {
		for (int i = 0; i < 9; i++) {
			ArrayList<Integer> rowArray = new ArrayList<>();
			ArrayList<Integer> colArray = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				rowArray.add(map[i][j]);
				colArray.add(map[j][i]);
			}
			for (int j = 1; j <= 9; j++) {
				if (!rowArray.contains(j))
					return false;
				if (!colArray.contains(j))
					return false;
			}
		}
		return true;
	}

	static boolean box() {
		// 행
		for (int k = 0; k < 9; k += 3) {
			// 열
			for(int i = 0; i < 9; i += 3) {
				ArrayList<Integer> boxArray = new ArrayList<>();
				for(int j = k; j < k + 3; j++) {
					for(int l = i; l < i + 3; l++) {
						boxArray.add(map[j][l]);
					}
				}
				for (int j = 1; j <= 9; j++) {
					if (!boxArray.contains(j))
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(RowCol() && box()) System.out.println("#" + tc + " " + 1);
			else System.out.println("#" + tc + " " + 0);
		}
	}
}
