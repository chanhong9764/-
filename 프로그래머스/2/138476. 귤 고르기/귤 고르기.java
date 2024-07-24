import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        Map<Integer, Integer> list = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            list.put(tangerine[i], list.getOrDefault(tangerine[i], 0) + 1);
        }
        for(Integer key : list.keySet()) {
            pq.add(new int[] {key, list.get(key)});
        }
        int temp = 0;
        while(temp < k) {
            temp += pq.poll()[1];
            answer++;
        }
        return answer;
    }
}