import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        
        for(int i = 0; i < Math.min(k, enemy.length); i++) {
            pq.add(enemy[i]);
        }
        
        for(int i = Math.min(k, enemy.length); i < enemy.length; i++) {
            if(enemy[i] > pq.peek()) {
                n -= pq.poll();
                pq.add(enemy[i]);
            } else {
                n -= enemy[i];   
            }
            if(n < 0) {
                break;
            }
            answer++;
        }
        answer += pq.size();
        return answer;
    }
}