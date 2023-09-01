import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2252 {
	static int N, M;
	static ArrayList<Integer>[] people;
	static ArrayList<Integer> Ans = new ArrayList<>();
	static ArrayDeque<Integer> q = new ArrayDeque<>();;
	static int[] count;
	
	static void topological() {
		while(!q.isEmpty()) {
			int t = q.poll();
			
			Ans.add(t);
			
			for(int b : people[t]) {
				count[b]--;
				if(count[b] == 0) {
					q.add(b);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		people = new ArrayList[N + 1];
		count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			people[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			people[a].add(b);
			count[b]++;
		}
		for(int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				q.add(i);
			}
		}
		topological();
		for(int i = 0; i < Ans.size(); i++) {
			System.out.print(Ans.get(i) + " ");
		}
	}
}
