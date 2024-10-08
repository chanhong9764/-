import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        for(int i = 0; i < 5; i++) {
            String[] curr = places[i];
            boolean isContinue = true;
            for(int j = 0; j < 5; j++) {
                String t = places[i][j];
                for(int k = 0; k < 5; k++) {
                    if(t.charAt(k) == 'P') {
                        answer[i] = isValid(j, k, curr) ? 1 : 0;
                        if(answer[i] == 0) break;
                    }
                }
                if(answer[i] == 0) break;
            }
            System.out.println();
        }
        
        return answer;
    }
    public static boolean isValid(int x, int y, String[] place) {
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
        
        // 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            for(int j = 1; j <= 2; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                
                if(nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                    continue;
                }
                if(place[nx].charAt(ny) == 'X') break;
                if(place[nx].charAt(ny) == 'P') {
                    return false;
                }
            }
        }
        // 대각선 탐색
        for(int i = 4; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
                
            if(nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                continue;
            }
            if(place[nx].charAt(ny) == 'P') {
                if(place[nx].charAt(y) == 'X' && place[x].charAt(ny) == 'X') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}