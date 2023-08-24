import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*    0 - 흰색
 *  1 - 빨간색
 *  2 - 파란색
 *  범위 밖 - 파란색
 */

public class BOJ17837 {
	static class horse {
		int x;
		int y;
		int direction;

		public horse(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}

	static int N, K;
	static boolean answerCheck = false;
	static int[][] map;
	static ArrayDeque<Integer>[][] horseMap;
	static horse[] h;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	static void whiteMoving(horse cur, int idx, int nx, int ny) {
		int size = horseMap[cur.x][cur.y].size();
		boolean isValid = false;
		
		for (int i = 0; i < size; i++) {
			int value = horseMap[cur.x][cur.y].poll();

			if (value == idx) {
				isValid = true;
			}
			
			if (isValid) {
				horseMap[nx][ny].add(value);
				h[value].x = nx;
				h[value].y = ny;
			} else {
				horseMap[cur.x][cur.y].add(value);
			}
			
			if (horseMap[nx][ny].size() >= 4) {
				answerCheck = true;
				return;
			}
		}
	}

	static void redMoving(horse cur, int idx, int nx, int ny) {
		int size = horseMap[cur.x][cur.y].size();
		for (int i = size - 1; i >= 0; i--) {
			int value = horseMap[cur.x][cur.y].pollLast();
			horseMap[nx][ny].add(value);
			h[value].x = nx;
			h[value].y = ny;
			if (horseMap[nx][ny].size() >= 4) {
				answerCheck = true;
				return;
			}
			if (value == idx) {
				break;
			}
		}
	}

	static void movingHorse(int idx) {
		horse cur = new horse(h[idx].x, h[idx].y, h[idx].direction);
		int nx = cur.x + dx[cur.direction];
		int ny = cur.y + dy[cur.direction];
		// 함께 있는 좌표들의 값들도 바꿔줘야됨

		// 파란색
		if (nx > N || nx < 1 || ny > N || ny < 1 || map[nx][ny] == 2) {
			// 반대로 방향 전환
			if (cur.direction == 1) h[idx].direction = 2;
			else if (cur.direction == 2) h[idx].direction = 1;
			else if (cur.direction == 3) h[idx].direction = 4;
			else h[idx].direction = 3;
			// 전환 후 이동 값
			nx = cur.x + dx[h[idx].direction];
			ny = cur.y + dy[h[idx].direction];
			// 전환 후 이동 값이 파란색이면 중단
			if (nx > N || nx < 1 || ny > N || ny < 1 || map[nx][ny] == 2)
				return;
			// 아니면 재귀를 통해 이동
			movingHorse(idx);
			return;
			
		} else if (map[nx][ny] == 0) {
			// 흰색
			whiteMoving(cur, idx, nx, ny);
			if(answerCheck) return;
		} else if (map[nx][ny] == 1){
			// 빨간색
			redMoving(cur, idx, nx, ny);
			if(answerCheck) return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		horseMap = new ArrayDeque[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				horseMap[i][j] = new ArrayDeque<>();
			}
		}

		h = new horse[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			horseMap[row][col].add(i);
			h[i] = new horse(row, col, direction);
		}

		int idx = 1;
		int count = 1;
		while (true) {
			movingHorse(idx);
			if (answerCheck) {
				System.out.println(count);
				return;
			}
			if (idx == K) {
				idx = 0;
				count++;
				if (count > 1000) {
					System.out.println(-1);
					return;
				}
			}
			idx++;
		}
	}
}