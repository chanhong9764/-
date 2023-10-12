import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num, dist;
		
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return this.num + " " + this.dist;
		}
	}
	static int N, M;
	static HashMap<Integer, Integer> map;
	static int[] visited = new int[101];
	static int Ans = Integer.MAX_VALUE;
	
	static void bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(1, 0));
		visited[1] = 0;
		
		while(!q.isEmpty()) {
			Node t = q.poll();

			if(t.num == 100) {
				Ans = Math.min(Ans, t.dist);
				continue;
			}
			
			if(map.containsKey(t.num)) {
				int temp = map.get(t.num);
				
				if(visited[temp] > t.dist) {
					visited[temp] = t.dist;
					q.add(new Node(temp, t.dist));
				}
			} else {
				for(int i = 1; i <= 6; i++) {
					int tn = t.num + i;
					
					if(tn > 100) break;
					
					if(visited[tn] > t.dist + 1) {
						visited[tn] = t.dist + 1;
						q.add(new Node(tn, t.dist + 1));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map.put(s, d);
		}
		
		for(int i = 0; i <= 100; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
		bfs();
		System.out.println(Ans);
	}
}
