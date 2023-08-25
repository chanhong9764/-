import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1238 {
	static class Pos {
		int from;
		int to;
		
		public Pos(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	static int N, s;
	static ArrayList<Integer>[] contact;
	static boolean[] visited;
	
	static int bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(s);
		visited[s] = true;
		ArrayList<Integer> last = new ArrayList<>();
		int size = q.size();
		while(!q.isEmpty()) {
			if(size == 0) {
				size = q.size();
				last.clear();
				for(int i = 0; i < size; i++) {
					int temp = q.pollFirst();
					last.add(temp);
					q.add(temp);
				}
			}
			int t = q.poll();
			size--;
			for(int i = 0; i < contact[t].size(); i++) {
				int tempValue = contact[t].get(i);
				if(!visited[tempValue]) {
					visited[tempValue] = true;
					q.add(tempValue);
				}
			}
		}
		Collections.sort(last);
		return last.get(last.size() - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			contact = new ArrayList[101];
			visited = new boolean[101];
			
			for(int i = 1; i <= 100; i++) {
				contact[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from].add(to);
			}
			System.out.println("#" + tc + " " + bfs());
		}
	}
}
