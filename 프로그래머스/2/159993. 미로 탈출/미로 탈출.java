import java.util.*;
import java.io.*;

public class Solution {
    static class Pos {
        int x;
        int y;
        int dist;
        
        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int row, col;
    static char[][] map;
    static boolean[][] visited;
    static Pos laber, start, exit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int bfs(Pos s, Pos d) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(s.x, s.y, 0));
        visited[s.x][s.y] = true;
        
        while(!q.isEmpty()) {
            Pos t = q.poll();
            
            if(t.x == d.x && t.y == d.y) {
                return t.dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                
                if(nx >= row || nx < 0 || ny >= col || ny < 0 || map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }
                q.add(new Pos(nx, ny, t.dist + 1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        row = maps.length;
        col = maps[0].length();
        map = new char[row][col];
        
        for(int i = 0; i < row; i++) {
            String text = maps[i];
            for(int j = 0; j < col; j++) {
                char temp = text.charAt(j);
                if(temp == 'L') {
                    laber = new Pos(i, j, 0);
                } else if(temp == 'S') {
                    start = new Pos(i, j, 0);
                } else if(temp == 'E') {
                    exit = new Pos(i, j, 0);
                }
                map[i][j] = temp;
            }
        }
        visited = new boolean[row][col];
        int toLaber = bfs(start, laber);
        visited = new boolean[row][col];
        int toExit = bfs(laber, exit);
        
        if(toLaber != -1 && toExit != -1) {
            answer = toLaber + toExit;
        }
        return answer;
    }
}