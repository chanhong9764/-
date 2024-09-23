class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long start = 1;
        long end = limit;
        
        // 이분 탐색 시작
        while(start < end){
            long mid = (start + end) / 2;
            long result = calculate(mid, diffs, times);
        
            if(result > limit){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) start;
    }
    static public long calculate(long level, int[] diffs, int[] times) {
        // 초기 시간 설정
        long total = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(level >= diffs[i]) {
                total += times[i];
            } else {
                total += ((times[i - 1] + times[i]) * (diffs[i] - level)) + times[i];
            }
        }
        return total;
    }
}