import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] a = new int[N];
        	int[] b = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i< M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;

            if (N > M) {
                for (int i = 0; i <= N - M; i++) {
                    int total_value = 0;
                    for (int j = 0; j < M; j++) {
                        total_value += a[i + j] * b[j];
                    }
                    if (total_value > answer) {
                        answer = total_value;
                    }
                }
            } else {
                for (int i = 0; i <= M - N; i++) {
                    int total_value = 0;
                    for (int j = 0; j < N; j++) {
                        total_value += b[i + j] * a[j];
                    }
                    if (total_value > answer) {
                        answer = total_value;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
	}
}