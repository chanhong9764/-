import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static String[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Pos> teacher = new ArrayList<>();
	static ArrayList<Pos> blank = new ArrayList<>();
	static boolean[] visited;
	static boolean isValid = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				String input = st.nextToken();
				if(input.equals("X")) {
					blank.add(new Pos(i, j));
				} else if (input.equals("T")) {
					teacher.add(new Pos(i, j));
				}
				map[i][j] = input;
			}
		}
		visited = new boolean[blank.size()];
		recursive(0, 0);
		
		if(isValid) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	static boolean cctv() {
		for(int j = 0; j < teacher.size(); j++) {
			for(int i = 0; i < 4; i++) {
				int dist = 1;
				while(true) {
					int nx = teacher.get(j).x + dx[i]*dist;
					int ny = teacher.get(j).y + dy[i]*dist;

					if(nx >= N || nx < 0 || ny >= N || ny < 0 || map[nx][ny].equals("O")) {
						break;
					}
					if(map[nx][ny].equals("S")) {
						return false;
					}
					dist++;
				}
			}
		}
		return true;
	}
	
	static void recursive(int depth, int sel) {
		if(isValid) return;
		if(sel == 3) {
			ArrayList<Integer> wall = new ArrayList<>();
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					wall.add(i);
				}
			}
			// 벽 세우기
			for(int i = 0; i < 3; i++) {
				Pos t = blank.get(wall.get(i));
				map[t.x][t.y] = "O";
			}

			// 슨생님 감시
			isValid = cctv();
			
			//벽 제거
			for(int i = 0; i < 3; i++) {
				Pos t = blank.get(wall.get(i));
				map[t.x][t.y] = "X";
			}
			return;
		}
		
		for(int i = depth; i < blank.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				recursive(i + 1, sel + 1);
				visited[i] = false;
			}
		}
	}
}
