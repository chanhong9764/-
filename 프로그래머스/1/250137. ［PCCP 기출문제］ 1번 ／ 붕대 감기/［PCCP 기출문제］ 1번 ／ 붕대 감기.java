class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int length = attacks.length - 1;
        int sec = 1;
        int idx = 0;
        int skill = 0;
        
        // 몬스터의 마지막 공격 시간까지
        while(sec <= attacks[length][0]) {
            // 몬스터가 공격할 때
            if(attacks[idx][0] == sec) {
                skill = 0;
                answer -= attacks[idx][1];
                // 공격을 받고 체력이 0 이하가 되면 -1
                if(answer <= 0) {
                    return -1;
                }
                idx++;
            } else {
                skill++;
                // 최대 체력을 넘어가지 않게
                answer = calc_health(answer, bandage[1], health);
                // t초 연속으로 붕대를 감는 경우 추가 체력 회복
                if(skill % bandage[0] == 0) {
                    answer = calc_health(answer, bandage[2], health);
                }
            }
            sec++;
        }
        return answer;
    }
    
    // 체력 계산기
    static int calc_health(int health, int number, int maxValue) {
        int temp = health + number;
        if(temp > maxValue) {
            return maxValue;
        } else {
            return temp;
        }
    }
}