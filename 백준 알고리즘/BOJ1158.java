import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> number = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			number.add(i);
		}
		
		System.out.print("<");
		int idx = -1;
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < K; j++) {
				idx = (idx + 1) % number.size();
			}
			System.out.print(number.get(idx) + ", ");
			number.remove(idx--);
		}
		System.out.print(number.get(0));
		System.out.print(">");
	}
}
