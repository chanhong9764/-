import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
    private static int[][] rotate(int[][] numbers, int N) {
        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = numbers[N - 1 - j][i];
            }
        }
        return answer;
    }
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            int[][][] answer = new int[3][N][N];
            int[][] numbers = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 3; i++) {
                numbers = rotate(numbers, N);
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        answer[i][j][k] = numbers[j][k];
                    }
                }
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(answer[j][i][k]);
                    }
                    System.out.print(' ');
                }
                System.out.print('\n');
            }
        }
	}
}