import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
	static class meeting {
		int start;
		int end;
		public meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		meeting[] m = new meeting[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(m, new Comparator<meeting>(){

			@Override
			public int compare(meeting o1, meeting o2) {
				if(o1.end == o2.end)
					return o1.start - o2.start;
				return o1.end-o2.end; 
			}
			
		});
		
		int endTime = m[0].end;
		int ans = 1;
		
		for(int i = 1; i < m.length; i++) {
			if(m[i].start >= endTime) {
				ans += 1;
				endTime = m[i].end;
			}
		}
		
		System.out.println(ans);
	}
}
