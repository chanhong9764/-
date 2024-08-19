import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int index = 1;
        N = Integer.parseInt(br.readLine());
        int[][] map;
        while(N != 0) {
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + index + ": " + bfs(map));
            N = Integer.parseInt(br.readLine());
            index++;
        }
    }

    public static int bfs(int[][] map) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });
        q.add(new int[] {0, 0, map[0][0]});
        int[][] visited = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = map[0][0];

        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] t = q.poll();

            if(t[0] == N - 1 && t[1] == N - 1) {
                answer = Math.min(answer, t[2]);
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];

                if(nx >= N || nx < 0 || ny >= N || ny < 0) {
                    continue;
                }
                int temp = t[2] + map[nx][ny];
                if(visited[nx][ny] <= temp) continue;
                visited[nx][ny] = temp;
                q.add(new int[]{nx, ny, temp});
            }
        }
        return answer;
    }
}
