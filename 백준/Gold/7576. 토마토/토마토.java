import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int M, N;
	static int[][] box;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static ArrayDeque<Pos> q;
	static int ans;

	static void bfs() {
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int l = 0; l < qSize; l++) {
				Pos p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if (nx >= N || nx < 0 || ny >= M || ny < 0 || box[nx][ny] == -1 || box[nx][ny] == 1) {
						continue;
					}
					box[nx][ny] = 1;
					q.add(new Pos(nx, ny));
				}
			}
			ans++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		q = new ArrayDeque<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input != 0) {
					box[i][j] = input;
				}
				if(input == 1) {
					q.add(new Pos(i, j));
				}
			}
		}
		bfs();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans - 1);
	}
}
