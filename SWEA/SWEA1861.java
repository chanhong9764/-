import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA1861 {
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
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static boolean[][] visited;

	static int bfs(int x, int y) {
		ArrayDeque<Pos> q = new ArrayDeque<Pos>();
		visited = new boolean[n][n];
		visited[x][y] = true;
		int dist = 0;

		q.add(new Pos(x, y, 1));

		while (!q.isEmpty()) {
			Pos p = q.poll();
			dist = Math.max(dist, p.dist);
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= n || nx < 0 || ny >= n || ny < 0 || visited[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == map[p.x][p.y] + 1) {
					visited[nx][ny] = true;
					q.add(new Pos(nx, ny, p.dist + 1));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			int roomNumber = n * n;
			int roomCount = -1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = bfs(i, j);
					if (roomCount < temp) {
						roomNumber = map[i][j];
						roomCount = temp;
					}
					if(roomCount == temp && roomNumber > map[i][j]) {
						roomNumber = map[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + roomNumber + " " + roomCount);
		}
	}
}
