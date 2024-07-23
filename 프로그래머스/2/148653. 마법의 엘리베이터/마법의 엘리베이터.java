import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0) {
            int t = storey % 10;
            storey /= 10;
            
            if(t > 5) {
                answer += 10 - t;
                storey++;
            } else if(t == 5) {
                if(storey % 10 >= 5) {
                    storey++;
                }
                answer += t;
            } else {
                answer += t;
            }
        }
        return answer;
    }
}