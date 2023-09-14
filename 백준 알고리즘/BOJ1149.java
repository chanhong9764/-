import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					map[i][j] += Math.min(map[i - 1][j + 1], map[i - 1][j + 2]);
				} else if (j == 1) {
					map[i][j] += Math.min(map[i - 1][j - 1], map[i - 1][j + 1]);
				} else {
					map[i][j] += Math.min(map[i - 1][j - 1], map[i - 1][j - 2]);
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		
		for(int j = 0; j < 3; j++) {
			answer = Math.min(answer, map[N - 1][j]);
		}
		System.out.println(answer);
	}

}
