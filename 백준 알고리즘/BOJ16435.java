import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] fruits = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);
		int snake = L;
		for(int i = 1; i <= N; i++) {
			if(snake >= fruits[i]) {
				snake++;
			} else {
				break;
			}
		}
		System.out.println(snake);
	}
}
