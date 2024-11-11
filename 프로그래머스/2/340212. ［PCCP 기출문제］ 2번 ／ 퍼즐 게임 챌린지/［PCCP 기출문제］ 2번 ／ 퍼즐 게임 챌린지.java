import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long start = 1;
        long end = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            end = Math.max(end, diffs[i]);
        }
      
        // diff의 크기가 300,000이므로 NlogN 이하의 시간복잡도를 가지는 이분탐색 사용
        while(start <= end) {
            long mid = (start + end) / 2;
            long result = calculate(mid, diffs, times);
            
            // 현재 Level로 문제를 풀 수 없다면 숙련도 증가
            if(result > limit) {
                start = mid + 1;
                // 현재 Level로 문제를 풀 수 있다면 숙련도 감소
            } else {
                end = mid - 1;
            }
        }
        
        return (int) start;
    }
    static public long calculate(long level, int[] diffs, int[] times) {
        // 초기 시간 설정
        long total = 0;
        for(int i = 0; i < diffs.length; i++) {
            // level >= diff 일 때, time_cur 더하기 
            if(level >= diffs[i]) {
                total += times[i];
                // level < diff 일 때, (이전 문제 풀이 시간 + 현재 문제 풀이 시간) * (난이도 - 숙련도) + 현재 문제 풀이 시간
            } else {
                total += ((times[i - 1] + times[i]) * (diffs[i] - level)) + times[i];
            }
        }
        return total;
    }
}