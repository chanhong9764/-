import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<int[]> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        // 정렬
        Arrays.sort(records, (o1, o2) -> {
            String[] os1 = o1.split(" ");
            String[] os2 = o2.split(" ");
            if(Integer.parseInt(os1[1]) == Integer.parseInt(os2[1])) {
                String[] ot1 = os1[0].split(":");
                String[] ot2 = os2[0].split(":");
                if(Integer.parseInt(ot1[0]) == Integer.parseInt(ot2[0])) {
                    return Integer.parseInt(ot1[1]) - Integer.parseInt(ot2[1]);
                }
                return Integer.parseInt(ot1[0]) - Integer.parseInt(ot2[0]);
            }
            return Integer.parseInt(os1[1]) - Integer.parseInt(os2[1]);
        });
        
        for(int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
        int idx = 0;
        while(idx < records.length) {
            String[] record1 = records[idx].split(" ");
            String[] record2 = "".split("");
            if(idx != records.length - 1) {
                record2 = records[idx + 1].split(" ");
            }
            
            int h = 0;
            int m = 0;
            if(idx != records.length - 1 && record1[1].equals(record2[1])) {
                String[] rt1 = record1[0].split(":");
                String[] rt2 = record2[0].split(":");
                h = Integer.parseInt(rt2[0]) - Integer.parseInt(rt1[0]);
                m = 0;
                if(h == 0) {
                    m = Integer.parseInt(rt2[1]) - Integer.parseInt(rt1[1]);
                } else {
                    h -= 1;
                    m = 60 - Integer.parseInt(rt1[1]) + Integer.parseInt(rt2[1]);
                }
                idx += 2;
            } else {
                String[] rt1 = record1[0].split(":");
                h = 23 - Integer.parseInt(rt1[0]);
                m = 0;
                if(h == 0) {
                    m = 59 - Integer.parseInt(rt1[1]);
                } else {
                    h -= 1;
                    m = 60 - Integer.parseInt(rt1[1]) + 59;
                }
                idx++;
            }
            map.put(record1[1], map.getOrDefault(record1[1], 0) + h * 60 + m);
        }
        for(String k : map.keySet()) {
            int t = map.get(k);
            int money = 0;
            if(fees[0] >= t) {
                money = fees[1];
            } else {
                t -= fees[0];
                int m = t / fees[2];
                int n = t % fees[2];
                if(n != 0) {
                    m += 1;
                }
                money = fees[1] + (m * fees[3]);
            }
            ans.add(new int[] {Integer.parseInt(k), money});
        }
        ans.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i)[1];
        }
        return answer;
    }
}