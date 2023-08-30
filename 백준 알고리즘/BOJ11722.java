import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int Ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(array[i] > array[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			Ans = Math.max(Ans, dp[i]);
		}
		
		System.out.println(Ans);
	}
}