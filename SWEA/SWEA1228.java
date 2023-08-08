import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); 
			List<Integer> original = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				original.add(Integer.parseInt(st.nextToken()));
			}
			
			int C = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < C; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j = 0; j < count; j++) {
					original.add(idx + j, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#"+ tc + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(original.get(i) + " ");
			}
            System.out.println();
		}
	}

}
