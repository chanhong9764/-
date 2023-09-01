import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ1600 {
	static class Pos {
		int x;
		int y;
		int dist;
		int horseDist;

		public Pos(int x, int y, int dist, int horseDist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.horseDist = horseDist;
		}
	}

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] horseDx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] horseDy = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int Ans = Integer.MAX_VALUE;

	static boolean isValidBoundary(int x, int y) {
		if (x >= H || x < 0 || y >= W || y < 0 || map[x][y] == 1) {
			return false;
		}
		return true;
	}

	static int bfs() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Pos t = q.poll();
			
			if(t.x == H - 1 && t.y == W - 1) {
				return t.dist + t.horseDist;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];

				if (!isValidBoundary(nx, ny) || visited[nx][ny][t.horseDist]) {
					continue;
				}
				visited[nx][ny][t.horseDist] = true;
				q.add(new Pos(nx, ny, t.dist + 1, t.horseDist));
			}

			if (t.horseDist < K) {
				for (int i = 0; i < 8; i++) {
					int nx = t.x + horseDx[i];
					int ny = t.y + horseDy[i];

					if (!isValidBoundary(nx, ny) || visited[nx][ny][t.horseDist + 1]) {
						continue;
					}
					visited[nx][ny][t.horseDist + 1] = true;
					q.add(new Pos(nx, ny, t.dist, t.horseDist + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}
}
