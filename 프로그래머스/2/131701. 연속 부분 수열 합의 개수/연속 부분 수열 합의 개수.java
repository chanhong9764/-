import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                int temp = 0;
                int idx = j;
                int cnt = 0;
                while(cnt < i) {
                    if(idx >= elements.length) {
                        idx = 0;
                    }
                    temp += elements[idx++];
                    cnt++;
                }
                set.add(temp);
            }
        }

        answer = set.size();
        return answer;
    }
}