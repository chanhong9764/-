import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3040 {
	static int[] number = new int[9];
	static boolean[] visited = new boolean[9];
	static int[] sel = new int[7];
	
	static void combination(int depth, int k) {
		if(k == 7) {
			int total = 0;
			for(int i = 0; i < 7; i++) {
				total += number[sel[i]];
			}
			if(total == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(number[sel[i]]);
				}
			}
			return;
		}
		
		for(int i = depth; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[k] = i;
				combination(i + 1, k + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
	}
}