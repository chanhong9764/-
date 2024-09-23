import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        int end = targets[0][1];
        int index = 1;
        while(index < targets.length) {
            if(end <= targets[index][0]) {
                end = targets[index][1];
                answer++;
            }
            index++;
        }
        return answer + 1;
    }
}