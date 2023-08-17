import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11562 {
	static class Node {
		int idx;
		int dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	static int n, m, k;
	static ArrayList<Node>[] roadInfo;
	static int[][] distance;
	
	static int bfs(int start) {
		boolean[] visited = new boolean[n + 1];
		
		PriorityQueue<Node> temp = new PriorityQueue<>((o1, o2) -> {
			return Integer.compare(o1.dist, o2.dist);
		});
		
		temp.add(new Node(start, 0));

		while (!temp.isEmpty()) {
			Node t = temp.poll();
			distance[start][t.idx] = Math.min(distance[start][t.idx], t.dist);
			
			if (!visited[t.idx] && roadInfo[t.idx] != null) {
				visited[t.idx] = true;
				for (Node i : roadInfo[t.idx]) {
					temp.add(new Node(i.idx, i.dist + t.dist));
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		roadInfo = new ArrayList[n + 1];
		distance = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i <= n; i++) {
			roadInfo[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (b == 0) {
				roadInfo[u].add(new Node(v, 0));
				roadInfo[v].add(new Node(u, 1));
			} else {
				roadInfo[u].add(new Node(v, 0));
				roadInfo[v].add(new Node(u, 0));
			}
		}

		k = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(distance[a][b] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
