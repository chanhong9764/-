import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return this.x + " " + this.y + " ";
	}
}

public class BOJ16234 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans;
	static boolean isMoving = true;

	static void bfs(int x, int y) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		ArrayDeque<Node> changeQ = new ArrayDeque<>();
		q.add(new Node(x, y));
		changeQ.add(new Node(x, y));

		visited[x][y] = true;

		int people = map[x][y];
		int count = 1;

		while (!q.isEmpty()) {
			Node p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
					continue;
				}
				int diffCount = Math.abs(map[p.x][p.y] - map[nx][ny]);
				if (diffCount < L || diffCount > R) {
					continue;
				}
				isMoving = true;
				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
				changeQ.add(new Node(nx, ny));
				people += map[nx][ny];
				count++;
			}
		}
		while (!changeQ.isEmpty()) {
			Node p = changeQ.poll();
			map[p.x][p.y] = people / count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while (isMoving) {
			isMoving = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			if(isMoving) ans++;
		}
		
		System.out.println(ans);
	}
}
