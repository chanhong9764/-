import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ16236 {
	static class Fish {
		int x;
		int y;
		int dist;

		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return this.x + " " + this.y + " " + this.dist + " ";
		}
	}

	static int[][] map;
	static Fish shark;
	static int eat = 0, sharkSize = 2, N, ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean isValid;

	static void bfs() {
		PriorityQueue<Fish> eatFish = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if (o1.dist == o2.dist && o1.x == o2.x) {
					return Integer.compare(o1.y, o2.y);
				} else if (o1.dist == o2.dist) {
					return Integer.compare(o1.x, o2.x);
				} else {
					return Integer.compare(o1.dist, o2.dist);
				}
			}
		});

		ArrayDeque<Fish> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Fish(shark.x, shark.y, 0));
		visited[shark.x][shark.y] = true;

		while (!q.isEmpty()) {
			Fish f = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = f.x + dx[i];
				int ny = f.y + dy[i];

				if (nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
					continue;
				}
				if(map[nx][ny] <= sharkSize) {
					q.add(new Fish(nx, ny, f.dist + 1));
					visited[nx][ny] = true;
					if(map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
						eatFish.add(new Fish(nx, ny, f.dist + 1));
					}
				}
			}
		}

		if (!eatFish.isEmpty()) {
			isValid = true;
			Fish dest = eatFish.poll();
			map[shark.x][shark.y] = 0;
			map[dest.x][dest.y] = 9;
			shark.x = dest.x;
			shark.y = dest.y;
			shark.dist = 0;
			eat++;
			if (eat == sharkSize) {
				sharkSize += 1;
				eat = 0;
			}
			ans += dest.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 9)
					shark = new Fish(i, j, 0);
				map[i][j] = input;
			}
		}

		while (true) {
			isValid = false;
			bfs();
			if (!isValid) {
				break;
			}
		}
		System.out.println(ans);
	}
}