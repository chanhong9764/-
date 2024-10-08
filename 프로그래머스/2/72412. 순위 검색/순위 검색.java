import java.util.*;

class Solution {
    static String[] lang = {"cpp", "java", "python"};
    static String[] role = {"backend", "frontend"};
    static String[] career = {"junior", "senior"};
    static String[] dish = {"chicken", "pizza"};
    static Map<String, ArrayList<Integer>> m = new HashMap<>();
    static int cnt = 0;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Arrays.sort(info, (o1, o2) -> {
            String[] t1 = o1.split(" ");
            String[] t2 = o2.split(" ");
            return Integer.parseInt(t1[4]) - Integer.parseInt(t2[4]);
        });
        
        for(int i = 0; i < info.length; i++) {
            String[] t = info[i].split(" ");
            ArrayList<Integer> ta = m.get(t[0] + t[1] + t[2] + t[3]);

            if(ta == null) {
                m.put(t[0] + t[1] + t[2] + t[3], new ArrayList<>(Arrays.asList(Integer.parseInt(t[4]))));
            } else {
                ta.add(Integer.parseInt(t[4]));
                m.put(t[0] + t[1] + t[2] + t[3], ta);
            }
        }
        
        for(int i = 0; i < query.length; i++) {
            String[] t = query[i].split(" and ");
            int score = Integer.parseInt(t[3].split(" ")[1]);
            t[3] = t[3].split(" ")[0];
            cnt = 0;
            backtracking(t, "", 0, score);
            answer[i] = cnt;
        }
        // binarySearch(new ArrayList<Integer>(Arrays.asList(140, 200, 210)), 150);
        return answer;
    }
    
    public static int binarySearch(ArrayList<Integer> t, int score) {
        int left = 0;
        int right = t.size() - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(t.get(mid) < score) left = mid + 1;
            else if (t.get(mid) >= score) right = mid - 1;
        }
        if(t.size() != 1) {
            return t.size() - left;
        } else {
            return (score <= t.get(0) ? 1 : 0);
        }
    }
    
    public static void backtracking(String[] t, String word, int idx, int score) {
        if(idx == 4) {
            ArrayList<Integer> temp = m.get(word);
            if(temp != null) {
                cnt += binarySearch(temp, score);
                // for(int i = 0; i < temp.size(); i++) {
                //     if(temp.get(i) >= score) {
                //         cnt++;
                //     }
                // }
            }
            return;
        }
        if(t[idx].equals("-")) {
            if(idx == 0) {
                for(int i = 0; i < 3; i++) {
                    backtracking(t, word + lang[i], idx + 1, score);
                }   
            } else if(idx == 1) {
                for(int i = 0; i < 2; i++) {
                    backtracking(t, word + role[i], idx + 1, score);
                }   
            } else if(idx == 2) {
                for(int i = 0; i < 2; i++) {
                    backtracking(t, word + career[i], idx + 1, score);
                }   
            } else {
                for(int i = 0; i < 2; i++) {
                    backtracking(t, word + dish[i], idx + 1, score);
                }   
            } 
        } else {
            backtracking(t, word + t[idx], idx + 1, score);
        }
    }
}