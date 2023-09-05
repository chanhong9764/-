import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15971 {
	static class Node {
		int idx;
		int dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	static int N, a, b;
	static ArrayList<Node>[] link;
	static boolean[] visited;
	static ArrayList<Integer> values;
	static int Ans = Integer.MAX_VALUE;
	
	static void dfs(int start, int distance) {
		if(start == b) {
			int total = 0;
			
			for(int i = 0; i < values.size(); i++) {
				total = values.get(i);
				
				if(i + 1 < values.size()) {
					total += values.get(values.size() - 1) - values.get(i + 1);
				}
				
				Ans = Math.min(Ans, total);
			}
			return;
		}
		
		for(int i = 0; i < link[start].size(); i++) {
			Node cur = link[start].get(i);
			if(!visited[cur.idx]) {
				visited[cur.idx] = true;
				values.add(distance + cur.dist);
				dfs(cur.idx, distance + cur.dist);
				values.remove(values.size() - 1);
				visited[cur.idx] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		link = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		values = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			link[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			link[s].add(new Node(d, w));
			link[d].add(new Node(s, w));
		}
		visited[a] = true;
		values.add(0);
		dfs(a, 0);
		System.out.println(Ans);
	}
}
