import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}

	static int R, C;
	static char[][] map;
	static Pos biber;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayDeque<Pos> water, hedgehog;
	static boolean isValid = false, isAns = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		water = new ArrayDeque<>();
		hedgehog = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				char character = input.charAt(j);

				if (character == 'D') {
					biber = new Pos(i, j);
				} else if (character == 'S') {
					hedgehog.add(new Pos(i, j));
				} else if (character == '*') {
					water.add(new Pos(i, j));
				}
				map[i][j] = character;
			}
		}
		
		int cnt = 0;
		
		while(!isValid) {
			spreadWater();
			if(spreadHedge() == 0) {
				break;
			}
			cnt++;
		}
		if(isValid) {
			System.out.println(cnt);
		} else {
			System.out.println("KAKTUS");
		}
	}

	public static int spreadHedge() {
		int size = hedgehog.size();
		int cnt = 0;
		for (int j = 0; j < size; j++) {
			Pos t = hedgehog.poll();

			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];

				if (nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == 'S' || map[nx][ny] == '*' || map[nx][ny] == 'X') {
					continue;
				}
				cnt++;
				if (nx == biber.x && ny == biber.y) {
					isValid = true;
					return cnt;
				}

				map[nx][ny] = 'S';
				hedgehog.add(new Pos(nx, ny));
			}
		}
		return cnt;
	}

	public static void spreadWater() {
		int size = water.size();
		for(int j = 0; j < size; j++) {
			Pos t = water.poll();

			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];

				if (nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D') {
					continue;
				}
				map[nx][ny] = '*';
				water.add(new Pos(nx, ny));
			}
		}
	}

}
