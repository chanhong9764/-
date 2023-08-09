import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {
	static int N, M, R;
	static int[][] map;

	// 1번
	static void upDown() {
		int tr = map.length;
		int tc = map[0].length;

		int[][] copyMap = new int[tr][tc];
		for (int i = 0; i < tr; i++) {
			for (int j = 0; j < tc; j++) {
				copyMap[i][j] = map[tr - i - 1][j];
			}
		}
		for (int i = 0; i < tr; i++) {
			for (int j = 0; j < tc; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	// 2번
	static void leftRight() {
		int tr = map.length;
		int tc = map[0].length;

		int[][] copyMap = new int[tr][tc];
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tr; j++) {
				copyMap[j][i] = map[j][tc - i - 1];
			}
		}
		for (int i = 0; i < tr; i++) {
			for (int j = 0; j < tc; j++) {
				map[i][j] = copyMap[i][j];
			}
		}

	}

	// 3번
	static void rotateRight() {
		int tr = map.length;
		int tc = map[0].length;

		int[][] copyMap = new int[tc][tr];
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tr; j++) {
				copyMap[i][j] = map[tr - j - 1][i];
			}
		}
		map = new int[tc][tr];
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tr; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	// 4번
	static void rotateLeft() {
		int tr = map.length;
		int tc = map[0].length;

		int[][] copyMap = new int[tc][tr];
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tr; j++) {
				copyMap[i][j] = map[j][tc - i - 1];
			}
		}
		map = new int[tc][tr];
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tr; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	// 5번
	static void movingRight() {
		int tr = map.length;
		int tc = map[0].length;
		int[][] copyMap = new int[tr][tc];
		int nr = tr / 2;
		int nc = tc / 2;

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				// 1번 이동
				copyMap[i][nc + j] = map[i][j];
				// 2번 이동
				copyMap[nr + i][nc + j] = map[i][nc + j];
				// 3번 이동
				copyMap[nr + i][j] = map[nr + i][nc + j];
				// 4번 이동
				copyMap[i][j] = map[nr + i][j];
			}
		}

		for (int i = 0; i < tr; i++) {
			for (int j = 0; j < tc; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	// 6번
	static void movingLeft() {
		int tr = map.length;
		int tc = map[0].length;
		int[][] copyMap = new int[tr][tc];
		int nr = tr / 2;
		int nc = tc / 2;

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				// 1번 이동
				copyMap[nr + i][j] = map[i][j];
				// 4번 이동
				copyMap[nr + i][nc + j] = map[nr + i][j];
				// 3번 이동
				copyMap[i][nc + j] = map[nr + i][nc + j];
				// 2번 이동
				copyMap[i][j] = map[i][nc + j];
			}
		}

		for (int i = 0; i < tr; i++) {
			for (int j = 0; j < tc; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				movingRight();
				break;
			default:
				movingLeft();
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}