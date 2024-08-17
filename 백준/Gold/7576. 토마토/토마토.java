import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] tomato;
    static ArrayDeque<Pos> good_tomato = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    good_tomato.add(new Pos(i, j));
                }
                tomato[i][j] = temp;
            }
        }
        bfs();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) {
                    answer = -1;
                    break;
                }
            }
            if(answer == -1) break;
        }
        System.out.println(answer);
    }
    public static void bfs() {
        while(!good_tomato.isEmpty()) {
            int size = good_tomato.size();
            for(int i = 0; i < size; i++) {
                Pos t = good_tomato.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];

                    if (nx >= N || nx < 0 || ny >= M || ny < 0 || tomato[nx][ny] == 1 || tomato[nx][ny] == -1) {
                        continue;
                    }
                    tomato[nx][ny] = 1;
                    good_tomato.add(new Pos(nx, ny));
                }
            }
            answer++;
        }
    }
}
