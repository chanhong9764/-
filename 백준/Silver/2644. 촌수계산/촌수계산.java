import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] relation;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        relation = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relation[s][e] = 1;
            relation[e][s] = 1;
        }
        System.out.println(bfs(start, end));
    }
    public static int bfs(int start, int end) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start, 0});

        while (!q.isEmpty()) {
            int[] t = q.poll();

            if(t[0] == end) {
                return t[1];
            }

            for(int i = 1; i <= N; i++) {
                if(relation[t[0]][i] == 1 && !visited[t[0]][i]) {
                    visited[t[0]][i] = true;
                    q.add(new int[] {i, t[1] + 1});
                }
            }
        }
        return -1;
    }
}
