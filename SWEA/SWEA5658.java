import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA5658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayDeque<Character> q = new ArrayDeque<>();
			ArrayList<Integer> array = new ArrayList<>();
			
			String input = br.readLine();
			for (int i = 0; i < N; i++) {
				q.add(input.charAt(i));
			}

			for (int k = 0; k < N / 4; k++) {
				for (int i = 0; i < 4; i++) {
					char[] temp = new char[N / 4];
					for (int j = 0; j < N / 4; j++) {
						temp[j] = q.poll();
						q.add(temp[j]);
					}
					int num = Integer.parseInt(String.valueOf((temp)), 16);
					if(!array.contains(num)) {
						array.add(num);
					}
				}
				q.addFirst((q.pollLast()));
			}
			Collections.sort(array, Collections.reverseOrder());
			System.out.println("#" + tc + " " + array.get(K - 1));
		}
	}
}
