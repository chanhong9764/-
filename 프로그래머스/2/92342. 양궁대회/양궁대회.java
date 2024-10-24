class Solution {
    static int[] result;
    static int[] ans;
    static int maxValue = 0;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        result = new int[11];
        ans = new int[11];
        backtracking(0, n, info, 0);
        
        if(maxValue == 0) {
            answer = new int[] {-1};
        } else {
            answer = ans;
        }
        return answer;
    }
    
    public static void backtracking(int cnt, int n, int[] info, int index) {
        if(cnt == n) {
            int lion = 0;
            int apeach = 0;
            for(int i = 0; i < result.length; i++) {
                if(result[i] > info[i]) {
                    lion += 10 - i;
                } else {
                    if(info[i] != 0) {
                        apeach += 10 - i;
                    }
                }
            
            }
            if(lion > apeach) {
                if(maxValue < lion - apeach) {
                    for(int i = 0; i < result.length; i++) {
                        ans[i] = result[i];
                    }
                    maxValue = lion - apeach;
                } else if (maxValue == lion - apeach) {
                    boolean isValid = true;
                    for(int i = result.length - 1; i >= 0; i--) {
                        if(ans[i] < result[i]) {
                            isValid = false;
                            break;
                        } else if (ans[i] > result[i]) {
                            break;
                        }
                    }
                    if(!isValid) {
                        for(int i = 0; i < result.length; i++) {
                            ans[i] = result[i];
                        }
                    }
                    maxValue = lion - apeach;
                }
            }
            return;
        }
        
        for(int i = index; i < result.length; i++) {
            if(info[i] >= result[i]){
                result[i] += 1;
                backtracking(cnt + 1, n, info, i);
                result[i] -= 1;
            }
        }
    }
}