import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i <= discount.length - 10; i++) {
            m = new HashMap<>();
            for(int j = 0; j < 10; j++) {
                m.put(discount[i + j], m.getOrDefault(discount[i + j], 0) + 1);
            }
            boolean isValid = true;
            for(int j = 0; j < want.length; j++) {
                if(m.getOrDefault(want[j], 0) < number[j]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                answer++;
            }
        }
        return answer;
    }
}