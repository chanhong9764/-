import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
    private static int plus(int[][] flies, int x, int y, int N, int M) {
        int plus = flies[x][y];
        
		int[] plusCol = {-1, 0, 1, 0};
        int[] plusRow = {0, 1, 0, -1};

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + plusCol[j] * i;
                int ny = y + plusRow[j] * i;
                
                if ((nx >= N) || (nx < 0) || (ny >= N) || (ny < 0)) {
                    continue;
                }
                plus += flies[nx][ny];
            }
        }
       
        return plus;
    }
     private static int cross(int[][] flies, int x, int y, int N, int M) {
        int cross = flies[x][y];
         
        int[] crossCol = {1, -1, -1, 1};
        int[] crossRow = {1, 1, -1, -1};

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + crossCol[j] * i;
                int ny = y + crossRow[j] * i;
                
                if ((nx >= N) || (nx < 0) || (ny >= N) || (ny < 0)) {
                    continue;
                }
                cross += flies[nx][ny];
            }
        }
        
        return cross;
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] flies = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int plusTotal = plus(flies, i, j, N, M);
                    int crossTotal = cross(flies, i, j, N, M);
                    answer = plusTotal > answer ? plusTotal : answer;
                    answer = crossTotal > answer ? crossTotal : answer;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
	}
}