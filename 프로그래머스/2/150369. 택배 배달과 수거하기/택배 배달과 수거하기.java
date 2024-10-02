import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        ArrayDeque<Integer> d = new ArrayDeque<>();
        ArrayDeque<Integer> p = new ArrayDeque<>();
        
        for(int i = 0; i < deliveries.length; i++) {
            d.add(deliveries[i]);
        }
        for(int i = 0; i < pickups.length; i++) {
            p.add(pickups[i]);
        }
        
        while(!d.isEmpty() || !p.isEmpty()) {
            int dist = 0;
            int stock = cap;
            while(!d.isEmpty()) {
                int t = d.pollLast();
                if(t == 0) continue;
                if(stock > t) {
                    stock -= t;
                    dist = Math.max(dist, d.size() + 1);
                } else if (stock < t) {
                    t -= stock;
                    d.add(t);
                    dist = Math.max(dist, d.size());
                    break;
                } else {
                    dist = Math.max(dist, d.size() + 1);
                    break;
                }
            }
            int store = 0;
            while(!p.isEmpty()) {
                int t = p.pollLast();
                if(t == 0) continue;
                
                if(store + t <= cap) {
                    store += t;
                    dist = Math.max(dist, p.size() + 1);
                } else if(store + t > cap){
                    t = store + t - cap;
                    p.add(t);
                    dist = Math.max(dist, p.size());
                    break;
                } else {
                    dist = Math.max(dist, p.size() + 1);
                    break;
                }
            }
            answer += dist * 2;
        }
        return answer;
    }
}