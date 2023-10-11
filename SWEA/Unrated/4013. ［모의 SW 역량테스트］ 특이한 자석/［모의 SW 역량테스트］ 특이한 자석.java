import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int T, K;
	static ArrayList<Integer>[] magnetic;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc ++) {
			K = Integer.parseInt(br.readLine());
			magnetic = new ArrayList[4];
			
			for(int i = 0; i < 4; i++) {
				magnetic[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnetic[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int sel = Integer.parseInt(st.nextToken()) - 1;
				int rotate = Integer.parseInt(st.nextToken());
				
				visited = new boolean[4];
				visited[sel] = true;
				rotateFunc(sel, rotate);
			}
			
			int Ans = 0;
			for(int i = 0; i < 4; i++) {
				if(magnetic[i].get(0) == 1) {
					Ans += Math.pow(2, i);
				}
			}
			System.out.println("#" + tc + " " + Ans);
		}
	}

	private static void rotateFunc(int sel, int rotate) {
		int left = sel - 1;
		int right = sel + 1;
		
		if(left < 0) {
			int curValue = magnetic[sel].get(2);
			int rightValue = magnetic[right].get(6);
			
			if(curValue != rightValue) {
				if(!visited[right]) {
					visited[right] = true;
					rotateFunc(right, rotate*-1);
				}
			}
		} else if (right > 3) {
			int curValue = magnetic[sel].get(6);
			int leftValue = magnetic[left].get(2);
			
			if(curValue != leftValue) {
				if(!visited[left]) {
					visited[left] = true;
					rotateFunc(left, rotate*-1);
				}
			}
		} else {
			int curLeftValue = magnetic[sel].get(6);
			int curRightValue = magnetic[sel].get(2);
			
			int leftValue = magnetic[left].get(2);
			int rightValue = magnetic[right].get(6);
			
			if(curLeftValue != leftValue) {
				if(!visited[left]) {
					visited[left] = true;
					rotateFunc(left, rotate*-1);
				}
			}
			
			if(curRightValue != rightValue) {
				if(!visited[right]) {
					visited[right] = true;
					rotateFunc(right, rotate*-1);
				}
			}
		}
		if(rotate == 1) {
			magnetic[sel].add(0, magnetic[sel].remove(7));
		} else {
			magnetic[sel].add(magnetic[sel].remove(0));
		}
	}
}
