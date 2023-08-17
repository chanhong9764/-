import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA4050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> price = new PriorityQueue<>((o1, o2) -> {
				return Integer.compare(o1, o2) * -1;
			});
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				price.add(Integer.parseInt(st.nextToken()));
			}
			int index = 1;
			
			while(!price.isEmpty()) {
				int temp = price.poll();
				if(index % 3 != 0) {
					ans += temp;
				}
				index++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
