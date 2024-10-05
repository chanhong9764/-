import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i += k) {
            answer += getCnt(getY(i, d), k);
        }
        return answer;
    }
    
    public static int getY(int x, int d) {
        return (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
    }
    
    public static int getCnt(int y, int k) {
        return (y / k) + 1;
    }
}