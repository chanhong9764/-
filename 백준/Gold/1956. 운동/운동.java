import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V + 1][V + 1];
        int INF = 100000000;
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                dist[i][j] = INF;
            }
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = INF;
        for(int i = 1; i <= V; i++) {
            ans = Math.min(ans, dist[i][i]);
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}
