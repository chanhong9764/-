import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static List<Pos> store;
	static List<Pos> house;
	static Pos[] sel;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		store = new ArrayList<>();
		house = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2) {
					store.add(new Pos(i, j));
				}
				if (input == 1) {
					house.add(new Pos(i, j));
				}
			}
		}
		visited = new boolean[store.size()];
		sel = new Pos[M];
		combination(0, 0);
		System.out.println(ans);
	}
	
	static int getDist() {
		int totalDist = 0;
		
		for(int i = 0; i < house.size(); i++) {
			int distStore = Integer.MAX_VALUE;
			for(int j = 0; j < M; j++) {
				distStore = Math.min(Math.abs(house.get(i).x - sel[j].x) + Math.abs(house.get(i).y - sel[j].y), distStore);
			}
			totalDist += distStore;
		}

		return totalDist;
	}

	static void combination(int depth, int k) {
		if (k == M) {
			ans = Math.min(ans, getDist());
			return;
		}

		for (int i = depth; i < store.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[k] = store.get(i);
				combination(i + 1, k + 1);
				visited[i] = false;
			}
		}

	}
}
