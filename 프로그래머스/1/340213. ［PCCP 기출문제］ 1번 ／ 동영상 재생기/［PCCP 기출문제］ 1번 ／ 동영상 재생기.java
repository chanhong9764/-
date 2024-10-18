class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String curr = pos;

        if(compare_time(curr, op_start) && compare_time(op_end, curr)) {
            curr = op_end;
        }
        
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")) {
                curr = action(curr, op_start, op_end, video_len, true);
            } else {
                curr = action(curr, op_start, op_end, video_len, false);
            }
        }
        String[] a = curr.split(":");
        if(a[0].length() < 2) {
            answer += "0" + a[0];
        } else {
            answer += a[0];
        }
        if(a[1].length() < 2) {
            answer += ":0" + a[1];
        } else {
            answer += ":" + a[1];
        }
        return answer;
    }
    
    public static String action(String curr, String op_start, String op_end, String video_len, boolean func) {
        if(func) {
            curr = calc_time(curr, 10);
        } else {
            curr = calc_time(curr, -10);
        }
        
        if(compare_time(curr, op_start) && compare_time(op_end, curr)) {
            curr = op_end;
        }
        if(compare_time(curr, video_len)) {
            curr = video_len;
        }
        return curr;
    }
    
    public static boolean compare_time(String a, String b) {
        String[] at = a.split(":");
        String[] bt = b.split(":");
        
        if(Integer.parseInt(at[0]) > Integer.parseInt(bt[0])) {
            return true;
        } else if(Integer.parseInt(at[0]) < Integer.parseInt(bt[0])) {
            return false;
        } else {
            if(Integer.parseInt(at[1]) >= Integer.parseInt(bt[1])) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static String calc_time(String curr, int time) {
        String[] t = curr.split(":");
        int m = Integer.parseInt(t[1]) + time;
        int h = Integer.parseInt(t[0]);
        
        if(m >= 60) {
            h += 1;
            m -= 60;
        }
        
        if(m < 0) {
            if(h > 0) {
                h -= 1;
                m = 60 + m;
            } else {
                m = 0;
            }
        }
        return String.valueOf(h) + ":" + String.valueOf(m);
    }
}