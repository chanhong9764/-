import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17143 {
	static class shark implements Comparable<shark> {
		int x;
		int y;
		int s;
		int d;
		int z;

		public shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public int compareTo(shark o) {
			return Integer.compare(this.z, o.z)*-1;
		}

		@Override
		public String toString() {
			return this.x + " " + this.y + " " + this.s + " " + this.d + " " + this.z;
		}
	}

	static ArrayList<shark>[][] map;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Ans = 0;

		map = new ArrayList[R + 1][C + 1];
		ArrayList<shark>[][] tempMap = new ArrayList[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				map[i][j] = new ArrayList<>();
				tempMap[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y].add(new shark(x, y, s, d, z));
		}
		
		int index = 0;

		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(!map[i][j].isEmpty()) {
					map[i][j].sort(null);
					shark t = map[i][j].get(0);
					map[i][j].clear();
					map[i][j].add(t);
				}
			}
		}
		
		while (index != C) {
			// 낚시왕 이동
			index++;
			// 낚시왕이 있는 열에서 가장 가까운 상어 KILL
			for(int j = 1; j <= R; j++) {
				if(!map[j][index].isEmpty()) {
					Ans += map[j][index].get(0).z;
					map[j][index].clear();
					break;
				}
			}
			// 상어 이동
			for (int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					for(int k = 0; k < map[i][j].size(); k++) {
						shark t = map[i][j].get(k);
						int nx = t.x;
						int ny = t.y;
			
						for (int l = 0; l < t.s; l++) {
							nx += dx[t.d];
							ny += dy[t.d];
			
								// 범위 밖으로 나갈 때 방향 전환
							if (nx > R || nx < 1 || ny > C || ny < 1) {
								// 원래 자리로 복귀
								nx -= dx[t.d];
								ny -= dy[t.d];
								// 방향 전환
								if (t.d == 1) t.d = 2;
								else if (t.d == 2) t.d = 1;
								else if (t.d == 3) t.d = 4;
								else t.d = 3;
								// 전환된 방향으로 이동
								nx += dx[t.d];
								ny += dy[t.d];
							}
						}
						t.x = nx;
						t.y = ny;
						tempMap[nx][ny].add(t);
					}
				}
			}
			
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					map[i][j].clear();
					if(!tempMap[i][j].isEmpty()) {
						tempMap[i][j].sort(null);
						map[i][j].add(tempMap[i][j].get(0));
						tempMap[i][j].clear();
					}
				}
			}
		}
		System.out.println(Ans);
	}
}
