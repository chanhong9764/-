import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static int[][] map;
	
	static void recursive(int x, int y, int N) {
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(map[i][j] != map[x][y]) {
					int divide = N / 2;
					System.out.print("(");
					recursive(x, y, divide);
					recursive(x, y + divide, divide);
					recursive(x + divide, y, divide);
					recursive(x + divide, y + divide, divide);
					System.out.print(")");
					return;
				}
			}
		}
		System.out.print(map[x][y]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		recursive(0, 0, N);
	}
}
