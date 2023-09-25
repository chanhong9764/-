import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14502 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[][] map;
	static int Ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Pos> virus = new ArrayList<>();
	static ArrayList<Pos> blank = new ArrayList<>();
	static boolean[] visited;
	
	static void bfs(int[][] tmap) {
		ArrayDeque<Pos> p = new ArrayDeque<>();
		
		for(Pos t : virus) {
			p.add(new Pos(t.x, t.y));
		}
		
		while(!p.isEmpty()) {
			Pos vt = p.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = vt.x + dx[i];
				int ny = vt.y + dy[i];
				
				if(nx >= N || nx < 0 || ny >= M || ny < 0 || tmap[nx][ny] != 0) {
					continue;
				}
				tmap[nx][ny] = 2;
				p.add(new Pos(nx, ny));
			}
		}
	}
	
	static void combination(int idx, int cnt) {
		if(cnt == 3) {
			int[][] temp = new int[N][M];
			
			for(int i = 0; i < N; i++) { 
				for(int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					temp[blank.get(i).x][blank.get(i).y] = 1;
				}
			}
			bfs(temp);
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(temp[i][j] == 0) {
						count++;
					}
				}
			}
			Ans = Math.max(Ans, count);
			return;
		}
		
		for(int i = idx; i < blank.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 2) {
					virus.add(new Pos(i, j));
				} else if(input == 0) {
					blank.add(new Pos(i, j));
				}
				map[i][j] = input;
			}
		}
		visited = new boolean[blank.size()];
		combination(0, 0);
		System.out.println(Ans);
	}
}
