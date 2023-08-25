import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
	static class Pos implements Comparable<Pos> {
		int d;
		int w;

		public Pos(int d, int w) {
			this.d = d;
			this.w = w;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static ArrayList<Pos>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new Pos(to, w));
		}

		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V + 1];

		PriorityQueue<Pos> q = new PriorityQueue<>();
		dist[S] = 0;
		q.add(new Pos(S, dist[S]));
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			if(visited[t.d]) continue;
			visited[t.d] = true;
			
			int size = list[t.d].size();
			
			for(int i = 0; i < size; i++) {
				Pos cur = list[t.d].get(i);
				
				if(!visited[cur.d] && dist[cur.d] > dist[t.d] + cur.w) {
					dist[cur.d] = dist[t.d] + cur.w;
					q.add(new Pos(cur.d, dist[cur.d]));
				}
			}
		}
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}
