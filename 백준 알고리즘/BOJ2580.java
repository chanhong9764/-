import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map = new int[9][9];
	static ArrayList<Pos> blank = new ArrayList<>();
	static boolean isEnd = false;
	
	static boolean validSudoku(int x, int y) {
		for(int i = 0; i < 9; i++) {
			if(map[x][i] == map[x][y] && i != y) return false;
			if (map[i][y] == map[x][y] && i != x) return false;
		}
		
		int nx = (x / 3) * 3;
		int ny = (y / 3) * 3;
		
		for(int i = nx; i < nx + 3; i++) {
			for(int j = ny; j < ny + 3; j++) {
				if(map[i][j] == map[x][y] && i != x && j != y) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void recursive(int n) {
		if(n == blank.size()) {
			isEnd = true;
			return;
		}
		int nx = blank.get(n).x;
		int ny = blank.get(n).y;
		
		for(int i = 1; i <= 9; i++) {
			map[nx][ny] = i;
			if(validSudoku(nx, ny)) {
				recursive(n + 1);
				if(isEnd) return;
			}
		}
		map[nx][ny] = 0;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) {
					blank.add(new Pos(i, j));
				}
				map[i][j] = temp;
			}
		}
		recursive(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
