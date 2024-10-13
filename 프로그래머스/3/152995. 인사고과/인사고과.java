import java.util.*;

class Solution {
    static class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] scores) {
        int answer = 1;
        Node wanho = new Node(scores[0][0], scores[0][1]);
        ArrayList<Node> list = new ArrayList<>();
        
        for(int i = 0; i < scores.length; i++) {
            list.add(new Node(scores[i][0], scores[i][1]));    
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o2.x - o1.x;
        });
        
        int m = 0;
        
        for(int i = 0; i < list.size(); i++) {
            if(wanho.x < list.get(i).x && wanho.y < list.get(i).y) {
                answer = -1;
                break;
            }
            if(m <= list.get(i).y) {
                m = list.get(i).y;
                if(list.get(i).x + list.get(i).y > wanho.x + wanho.y) {
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
}