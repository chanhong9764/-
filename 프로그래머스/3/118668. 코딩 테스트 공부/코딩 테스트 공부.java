import java.util.*;

class Solution {
    static class Node {
        int al;
        int co;
        int t;
        public Node(int al, int co, int t) {
            this.al = al;
            this.co = co;
            this.t = t;
        }
    }
    
    static int al, co, time;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[][] time_t = new int[151][151];
    
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        list.add(new int[] {0, 0, 1, 0, 1});
        list.add(new int[] {0, 0, 0, 1, 1});
        
        for(int i = 0; i < problems.length; i++) {
            al = Math.max(al, problems[i][0]);
            co = Math.max(co, problems[i][1]);
            list.add(new int[] {problems[i][0], problems[i][1], problems[i][2], problems[i][3], problems[i][4]});
        }
        
        for(int i = 0; i < 151; i++) {
            for(int j = 0; j < 151; j++) {
                time_t[i][j] = Integer.MAX_VALUE;
            }
        }

        time = Integer.MAX_VALUE;
        
        bfs(alp, cop);
        
        answer = time;
        return answer;
    }
    
    public static void bfs(int alp, int cop) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.t - o2.t;
        });
        
        pq.add(new Node(alp, cop, 0));
        
        while(!pq.isEmpty()) {
            Node t = pq.poll();
            
            t.al = Math.min(t.al, al);
            t.co = Math.min(t.co, co);
            
            if(al == t.al && co == t.co) {
                time = Math.min(time, t.t);
                continue;
            }
            
            if(time_t[t.al][t.co] <= t.t) {
                continue;
            }
            
            time_t[t.al][t.co] = t.t;
            
            for(int i = 0; i < list.size(); i++) {
                int[] tl = list.get(i);
                
                if(t.al >= tl[0] && t.co >= tl[1]) {
                    pq.add(new Node(t.al + tl[2], t.co + tl[3], t.t + tl[4]));
                }
            }
        }
        
    }
}