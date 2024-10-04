import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 정렬
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });
        
        for(int i = row_begin - 1; i <= row_end - 1; i++) {
            int[] t = data[i];
            int mod = 0;
            for(int j = 0; j < t.length; j++) {
                mod += t[j] % (i + 1);
            }
            answer ^= mod;
        }
    
        return answer;
    }
}