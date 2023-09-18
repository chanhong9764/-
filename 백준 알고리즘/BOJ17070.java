import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ17070 {
	static class Pos {
		int x, y, direction;

		public Pos(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	static int[][] map;
	static int N, Ans;

	static void bfs() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(1, 2, 1));
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			if(t.x == N && t.y == N) {
				Ans++;
				continue;
			}
			
			// 가로에서 왔을 경우
			if(t.direction == 1) {
				if(t.y + 1 <= N && map[t.x][t.y + 1] != 1) {
					q.add(new Pos(t.x, t.y + 1, 1));
				}
				if(t.y + 1 <= N && t.x + 1 <= N && map[t.x][t.y + 1] != 1 && map[t.x + 1][t.y] != 1 && map[t.x + 1][t.y + 1] != 1) {
					q.add(new Pos(t.x + 1, t.y + 1, 3));
				}
				// 세로에서 왔을 경우
			} else if(t.direction == 2) {
				if(t.x + 1 <= N && map[t.x + 1][t.y] != 1) {
					q.add(new Pos(t.x + 1, t.y, 2));
				}
				if(t.y + 1 <= N && t.x + 1 <= N && map[t.x][t.y + 1] != 1 && map[t.x + 1][t.y] != 1 && map[t.x + 1][t.y + 1] != 1) {
					q.add(new Pos(t.x + 1, t.y + 1, 3));
				}
			} else {
				// 대각선에서 왔을 경우
				if(t.x + 1 <= N && map[t.x + 1][t.y] != 1) {
					q.add(new Pos(t.x + 1, t.y, 2));
				}
				if(t.y + 1 <= N && map[t.x][t.y + 1] != 1) {
					q.add(new Pos(t.x, t.y + 1, 1));
				}
				if(t.y + 1 <= N && t.x + 1 <= N && map[t.x][t.y + 1] != 1 && map[t.x + 1][t.y] != 1 && map[t.x + 1][t.y + 1] != 1) {
					q.add(new Pos(t.x + 1, t.y + 1, 3));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(map[N][N] != 1) {
			bfs();
		}

		System.out.println(Ans);
	}
}
