import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++) {
            ArrayDeque<String> q = new ArrayDeque<>();
            String a = "";
            for(int j = 0; j < s.length(); j += i) {
                String temp = "";
                
                for(int k = j; k < (s.length() < j + i ? s.length() : j + i); k++) {
                    temp += s.charAt(k);
                }

                if(q.isEmpty()) {
                    q.add(temp);
                } else {
                    String t = q.peekLast();
                    if(t.equals(temp)) {
                        q.add(temp);
                    } else {
                        if(q.size() == 1) {
                            a += t;
                        } else {
                            a += q.size() + "" + t;
                        }
                        q = new ArrayDeque<>();
                        q.add(temp);
                    }
                }
            }
            if(!q.isEmpty()) {
                String t = q.peekLast();
                if(q.size() == 1) {
                    a += t;
                } else {
                    a += q.size() + "" + t;
                }
            }
            answer = Math.min(answer, a.length());
        }
        return answer;
    }
}