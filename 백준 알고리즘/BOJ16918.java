import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ16918 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			return (this.x == ((Pos) obj).x) && (this.y == ((Pos) obj).y);
		}

		@Override
		public String toString() {
			return this.x + " " + this.y + " ";
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static int R, C, N;
	static ArrayDeque<Pos> q;

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void installBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}
	}
	
	static void findBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					q.add(new Pos(i, j));
				}
			}
		}
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Pos p = q.poll();
			map[p.x][p.y] = '.';

			for (int j = 0; j < 4; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];

				if (nx >= R || nx < 0 || ny >= C || ny < 0) {
					continue;
				}
				map[nx][ny] = '.';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		q = new ArrayDeque<Pos>();
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) == 'O')
					q.add(new Pos(i, j));
				map[i][j] = input.charAt(j);
			}
		}
		N--;
		
		while (N > 0) {
			N--;
			findBomb();
			installBomb();
			if(N <= 0) {
				break;
			}
			N--;
			bfs();
		}
		print();
	}

}
