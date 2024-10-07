import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        
        m1.put(topping[0], 0);
        
        for(int i = 1; i < topping.length; i++) {
            m2.put(topping[i], m2.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 1; i < topping.length; i++) {
            if(m1.size() == m2.size()) {
                answer++;
            }
            m1.put(topping[i], m1.getOrDefault(topping[i], 0) + 1);
            
            if(m2.get(topping[i]) != null) {
                if(m2.get(topping[i]) - 1 == 0){
                    m2.remove(topping[i]);
                } else {
                    m2.put(topping[i], m2.get(topping[i]) - 1);
                }
            }
        }
        return answer;
    }
}