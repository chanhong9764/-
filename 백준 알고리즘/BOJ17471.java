import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17471 {
	static int[] people;
	static ArrayList<Integer>[] link;
	static ArrayList<Integer>[] section;
	static boolean[] visited;
	static boolean[] connected;
	static int Ans, N;
	
	static void dfs(int start, int sec) {
		
		for(int t : link[start]) {
			if(sec == 0) {
				if(!connected[t] && !section[1].contains(t)) {
					connected[t] = true;
					dfs(t, sec);
				}
			} else {
				if(!connected[t] && !section[0].contains(t)) {
					connected[t] = true;
					dfs(t, sec);
				}
			}
		}
	}
	
	static void recursive(int depth, int sel) {
		if(depth == sel + 1) {
			section[0] = new ArrayList<Integer>();
			section[1] = new ArrayList<Integer>();
			connected = new boolean[N + 1];
			
			for(int i = 1; i <= N; i++) {
				if(visited[i]) {
					section[0].add(i);
				} else {
					section[1].add(i);
				}
			}

			connected[section[0].get(0)] = true;
			dfs(section[0].get(0), 0);
			
			for(int i = 0; i < section[0].size(); i++) {
				if(!connected[section[0].get(i)]) {
					return;
				}
			}
			
			connected[section[1].get(0)] = true;
			dfs(section[1].get(0), 1);
			
			for(int i = 1; i <= N; i++) {
				if(!connected[i]) {
					return;
				}
			}
			
			int sec1 = 0;
			int sec2 = 0;
			
			for(int i = 0; i < section[0].size(); i++) {
				sec1 += people[section[0].get(i)];
			}
			
			for(int i = 0; i < section[1].size(); i++) {
				sec2 += people[section[1].get(i)];
			}
			Ans = Math.min(Ans, (int) Math.abs(sec1 - sec2));
			return;
		}
		
		for(int i = depth; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				recursive(depth + 1, sel);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		link = new ArrayList[N + 1];
		people = new int[N + 1];
		visited = new boolean[N + 1];
		section = new ArrayList[N + 1];
		Ans = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			link[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				link[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 1; i <= N / 2; i++) {
			recursive(1, i);
		}
		if(Ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Ans);
		}
	}
}
