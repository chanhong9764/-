import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251 {
	static class Vertex implements Comparable<Vertex> {
		int e;
		double w;

		public Vertex(int e, double w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.w, o.w);
		}
	}

	static int[] islandX;
	static int[] islandY;
	static int[] parents;
	static Double Ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Ans = 0.0;
			// 인접리스트
			ArrayList<Vertex>[] adj = new ArrayList[N];

			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}

			islandX = new int[N];
			islandY = new int[N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if (i == 0) {
						islandX[j] = Integer.parseInt(st.nextToken());
					} else {
						islandY[j] = Integer.parseInt(st.nextToken());
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double w = Math.sqrt(Math.pow(islandX[i] - islandX[j], 2) + Math.pow(islandY[i] - islandY[j], 2));
					adj[i].add(new Vertex(j, w));
					adj[j].add(new Vertex(i, w));
				}
			}

			double E = Double.parseDouble(br.readLine());
			// 방문배열
			boolean[] v = new boolean[N];
			// 거리배열
			double[] dist = new double[N];
			// 무한대로 초기화
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[0] = 0;
			
			PriorityQueue<Vertex> Q = new PriorityQueue<>();
			Q.add(new Vertex(0, dist[0]));
			
			int cnt = 0;
			while(!Q.isEmpty()) {
				// 최소 비용 정점
				Vertex p = Q.poll();
				// 이미 방문한 정점이라면 continue
				if(v[p.e]) continue;
				// 확정된 정점의 값을 추가
				cnt++;
				if(cnt == N) break;
				// p.e 기준 정점으로 삼는다.
				v[p.e] = true;
				
				int size = adj[p.e].size();
				
				for(int i = 0; i < size; i++) {
					// 기준 정점에서 연결된 정점
					Vertex cur = adj[p.e].get(i);
					// 연결된 정점이 방문되지 않았고
					// 새롭게 찾은 정점의 값이 기존에 찾았던 값보다 작다면
					// 거리 배열을 업데이트
					if(!v[cur.e] && dist[cur.e] > cur.w) {
						dist[cur.e] = cur.w;
						// 연결된 정점들을 Q에 저장
						Q.add(new Vertex(cur.e, cur.w));
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				Ans += E * Math.pow(dist[i], 2);
			}
			
			System.out.println("#" + tc + " " + Math.round(Ans));
		}
	}
}
