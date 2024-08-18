import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[][] dp = new int[N][M];
        int[][] ddp = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
                ddp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[N - 1][0] = map[N - 1][0];
        ddp[N - 1][M - 1] = map[N - 1][M - 1];

        for(int i = 0; i < M; i++) {
            for(int j = N - 1; j >= 0; j--) {
                // 아래
                if(i == 0) {
                    if(j == N - 1) continue;
                    dp[j][i] = dp[j + 1][i] + map[j][i];
                    // 왼쪽
                } else if(j == N - 1) {
                    if(i == 0) continue;
                    dp[j][i] = dp[j][i - 1] + map[j][i];
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]) + map[j][i];
                }
            }
        }

        for(int i = N - 1; i >= 0; i--) {
            for(int j = M - 1; j >= 0; j--) {
                if (i == N - 1) {
                    if(j == M - 1) continue;
                    ddp[i][j] = ddp[i][j + 1] + map[i][j];
                } else if (j == M - 1) {
                    if(i == N - 1) continue;
                    ddp[i][j] = ddp[i + 1][j] + map[i][j];
                } else {
                    ddp[i][j] = Math.max(ddp[i][j + 1], ddp[i + 1][j]) + map[i][j];
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < M; j++) {
                answer = Math.max(answer, dp[i][j] + ddp[i][j]);
            }
        }
        System.out.println(answer);
    }
}
