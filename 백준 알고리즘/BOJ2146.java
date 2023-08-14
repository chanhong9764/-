import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ2146 {
	static class Pos {
		int x;
		int y;
		int dist;

		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static boolean[][] visitedDist;
	static ArrayDeque<Pos> ground;
	static ArrayDeque<Pos> areaQ;
	static ArrayDeque<Pos> distQ;
	static int N, index = 1, ans = Integer.MAX_VALUE;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void areaBFS(int x, int y) {
		visited[x][y] = true;
		distQ.add(new Pos(x, y, 0));
		areaQ.add(new Pos(x, y, 0));
		visitedDist[x][y] = true;
		
		while (!areaQ.isEmpty()) {
			Pos p = areaQ.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				distQ.add(new Pos(nx, ny, 0));
				visitedDist[nx][ny] = true;
				areaQ.add(new Pos(nx, ny, 0));
				visited[nx][ny] = true;
			}
		}
	}

	static void distBFS() {
		ArrayDeque<Pos> tq = new ArrayDeque<Pos>();

		while (!distQ.isEmpty()) {
			boolean[][] v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visitedDist[i][j]) {
						v[i][j] = true;
					}
				}
			}
			
			tq.add(distQ.poll());

			while (!tq.isEmpty()) {
				Pos t = tq.poll();
				for (int i = 0; i < 4; i++) {
					int nx = t.x + dx[i];
					int ny = t.y + dy[i];

					if (nx >= N || nx < 0 || ny >= N || ny < 0 || v[nx][ny]) {
						continue;
					}

					v[nx][ny] = true;
					if (map[nx][ny] == 0) {
						tq.add(new Pos(nx, ny, t.dist + 1));
						continue;
					}
					ans = Math.min(ans, t.dist);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ground = new ArrayDeque<>();
		areaQ = new ArrayDeque<Pos>();
		distQ = new ArrayDeque<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1)
					ground.add(new Pos(i, j, 0));
				map[i][j] = input;
			}
		}
		int groundSize = ground.size();
		for (int i = 0; i < groundSize; i++) {
			Pos t = ground.poll();
			visitedDist = new boolean[N][N];
			if (!visited[t.x][t.y]) {
				areaBFS(t.x, t.y);
			}
			distBFS();
		}
		System.out.println(ans);
	}
}
