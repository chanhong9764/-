import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for(int i = s.length(); i >= 1; i--) {
            for(int j = 0; j + i <= s.length(); j++) {
                if(isValid(s, j, j + i - 1)) {
                    return i;
                }
            }
        }

        return answer;
    }
    
    public static boolean isValid(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}