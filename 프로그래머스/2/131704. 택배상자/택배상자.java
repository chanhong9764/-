import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int num = 1;
        int idx = 0;
        while(idx < order.length) {
            if(num < order[idx]) {
                dq.add(num++);
            } else if(num == order[idx]) {
                answer++;
                idx++;
                num++;
            } else {
                if(!dq.isEmpty() && dq.pollLast() == order[idx]) {
                    answer++;
                    idx++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}