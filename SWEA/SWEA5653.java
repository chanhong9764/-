import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static class Pos {
        int x;
        int y;
        int inActiveTime;
        int activeTime;
        boolean isSpread;
        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.inActiveTime = time;
            this.activeTime = time;
            this.isSpread = false;
        }
    }
    static Queue<Pos> inactiveQ;
    static Queue<Pos> activeQ;
    static int N, M, K, tc;
    static int[][] map;
    static int maxRow = 1000;
    static int maxCol = 1000;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
     
    static void recursive(int timer) {
        if(timer == K) {
            int ans = inactiveQ.size() + activeQ.size();
            System.out.println("#" + tc + " " + ans);
            return;
        }
        int inactiveSize = inactiveQ.size();
        int activeSize = activeQ.size();
         
        for(int i = 0; i < inactiveSize; i++) {
            Pos p = inactiveQ.poll();
            p.inActiveTime -= 1;
            if(p.inActiveTime <= 0) {
                activeQ.add(p);
            } else {
                inactiveQ.add(p);
            }
        }
         
        ArrayList<Pos> temp = new ArrayList<Pos>();
        for(int i = 0; i < activeSize; i++) {
            Pos p = activeQ.poll();
            p.activeTime -= 1;
            if(!p.isSpread) {
                for(int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                     
                    if(nx >= maxRow || nx < 0 || ny >= maxCol || ny < 0 || map[nx][ny] != 0) {
                        continue;
                    }
                    temp.add(new Pos(nx, ny, map[p.x][p.y]));
                }
                p.isSpread = true;
            }
            if(p.activeTime > 0) {
                activeQ.add(p);
            }
        }
         
        for(int i = 0; i < temp.size(); i++) {
            Pos p = temp.get(i);
            if(map[p.x][p.y] == 0) {
                map[p.x][p.y] = p.inActiveTime;
                inactiveQ.add(p);
            } else if(map[p.x][p.y] < p.activeTime) {
                activeQ.remove(new Pos(p.x, p.y, map[p.x][p.y]));
                map[p.x][p.y] = p.inActiveTime;
                inactiveQ.add(p);
            }
        }
        recursive(timer + 1);
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[maxRow][maxCol];
            inactiveQ = new LinkedList<Pos>();
            activeQ = new LinkedList<Pos>();
 
            int initX = (maxRow / 2) - (N / 2);
            int initY = (maxCol / 2) - (M / 2);
 
            for(int i = initX; i < initX + N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = initY; j < initY + M; j++) {
                    int temp = Integer.parseInt(st.nextToken()); 
                    if(temp != 0) {
                        inactiveQ.add(new Pos(i, j, temp));
                        map[i][j] = temp;
                    }
                }
            }
            recursive(0);
        }
    }
}