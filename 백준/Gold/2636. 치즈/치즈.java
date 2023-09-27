import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static ArrayDeque<Pos> q = new ArrayDeque<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= N || nx < 0 || ny >= M || ny < 0 || map[nx][ny] == 1 || visited[nx][ny]) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	static boolean melting(int x, int y) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(visited[nx][ny]) {
				cnt++;
				if(cnt >= 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Ans = 0;
		int cnt = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					q.add(new Pos(i, j));
				}
				map[i][j] = input;
			}
		}
		visited[0][0] = true;
		dfs(0, 0);
		
		while(!q.isEmpty()) {
            cnt = q.size();
			ArrayDeque<Pos> tq = new ArrayDeque<>();
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Pos t = q.poll();
				if(melting(t.x, t.y)) {
					tq.add(new Pos(t.x, t.y));
				} else {
					q.add(t);
				}
			}
			while(!tq.isEmpty()) {
				Pos t = tq.poll();
				visited[t.x][t.y] = true;
				dfs(t.x, t.y);
				map[t.x][t.y] = 0;
			}
			Ans++;
		}
		System.out.println(Ans);
        System.out.println(cnt);
	}
}
