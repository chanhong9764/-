import java.util.*;

class Solution {
    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int area = 0;
    static int maxSize = 0;
    static boolean[][] visited;
    static int[][] map;
    static int r, c;
    
    public int[] solution(int m, int n, int[][] picture) {
        map = picture.clone();
        c = n;
        r = m;
        area = 0;
        maxSize = 0;
        visited  = new boolean[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    maxSize = Math.max(bfs(i, j), maxSize);
                    area++;
                }
            }
        }
        int[] answer = {area, maxSize};
        return answer;
    }
    
    static int bfs(int x, int y) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(x, y));
        
        visited[x][y] = true;
        int size = 1;
        
        while(!q.isEmpty()) {
            Pos t = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || map[nx][ny] != map[x][y]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Pos(nx, ny));
                size++;
            }
        }
        return size;
    }
}