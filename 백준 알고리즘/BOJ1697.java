import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ1697 {
	static class Person {
		int position;
		int second;
		public Person(int position, int second) {
			this.position = position;
			this.second = second;
		}
	}
	
	static ArrayDeque<Person> q = new ArrayDeque<>();
	static boolean[] visited;
	static int a, b;

	static int bfs() {
		int ans = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			Person t = q.poll();
			
			if(t.position == b) {
				ans = Math.min(ans, t.second);
				break;
			}
			
			if(t.position - 1 >= 0 && !visited[t.position - 1]) {
				q.add(new Person(t.position - 1, t.second + 1));
				visited[t.position - 1] = true;
			}
			if(t.position + 1 <= 100000 && !visited[t.position + 1]) {
				q.add(new Person(t.position + 1, t.second + 1));
				visited[t.position + 1] = true;
			}
			if(t.position*2 <= 100000 && !visited[t.position*2]) {
				q.add(new Person(t.position*2, t.second + 1));
				visited[t.position*2] = true;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		visited[a] = true;
		q.add(new Person(a, 0));
		System.out.println(bfs());
	}	
}
