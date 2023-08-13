import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA1220 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayDeque<Pos> S, N;
	static String[][] map;
	static int ans;
	
	static void movingS() {
		while(!S.isEmpty()) {
			Pos p = S.poll();
			while(true) {
				p.x -= 1;
				
				if(p.x < 0) break;
				if(map[p.x][p.y].equals("1")) {
					ans++;
					break;
				}
				if(map[p.x][p.y].equals("2")) {
					break;
				}
			}
		}
	}

	static void movingN() {
		while(!N.isEmpty()) {
			Pos p = N.poll();
			
			while(true) {
				p.x += 1;
				
				if(p.x >= 100) break;
				
				if(map[p.x][p.y].equals("2")) {
					ans++;
					break;
				}
				if(map[p.x][p.y].equals("1")) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 빨간색 - 아래
		// 파란색 - 위
		for (int tc = 1; tc <= 10; tc++) {
			S = new ArrayDeque<>();
			N = new ArrayDeque<>();
			int square = Integer.parseInt(br.readLine());
			map = new String[square][square];
			ans = 0;
			
			for (int i = 0; i < square; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < square; j++) {
					String input = st.nextToken();
					if (input.equals("1")) {
						N.add(new Pos(i, j));
					} else if (input.equals("2")) {
						S.add(new Pos(i, j));
					}
					map[i][j] = input;
				}
			}
			movingS();
			movingN();
			System.out.println("#" + tc + " " + ans / 2);
		}
	}
}
