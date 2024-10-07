import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        long tq1 = 0;
        long tq2 = 0;
        boolean isValid = false;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            tq1 += queue1[i];
            tq2 += queue2[i];
        }
        
        while(tq1 != tq2) {
            if(answer == queue1.length * 3) {
                answer = -1;
                break;
            }
            if(tq1 > tq2) {
                int t = q1.pop();
                q2.add(t);
                tq1 -= t;
                tq2 += t;
            } else if(tq1 < tq2) {
                int t = q2.pop();
                q1.add(t);
                tq2 -= t;
                tq1 += t;
            }
            answer++;
        }
        return answer;
    }
}