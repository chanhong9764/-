import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N / 5; i++) {
			for(int j = 0; j <= N / 3; j++) {
				if((i*5 + j*3) == N) ans = Math.min(ans, i + j);
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}