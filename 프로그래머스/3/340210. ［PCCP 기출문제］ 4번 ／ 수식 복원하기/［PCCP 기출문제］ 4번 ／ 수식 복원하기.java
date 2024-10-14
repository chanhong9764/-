import java.util.*;

class Solution {
    static ArrayList<String> answerList;
    static ArrayList<int[]> list = new ArrayList<>();
    
    public String[] solution(String[] expressions) {
        String[] answer;
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        
        for(int i = 0; i <= 9; i++) {
            list.add(new int[] {i, 0});
        }
        
        for(int i = 0; i < expressions.length; i++) {
            if(expressions[i].contains("X")) {
                b.add(expressions[i]);
            } else {
                a.add(expressions[i]);
            }
        }
        
        answer = new String[b.size()];
        
        int aDigit = maxDigit(a);
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = aDigit; j <= 9; j++) {
                isValidA(a.get(i), j);
            }
        }
        
        int bDigit = maxDigit(b);
        for(int i = 0; i < b.size(); i++) {
            answerList = new ArrayList<>();
            for(int j = bDigit; j <= 9; j++) {
                if(list.get(j)[1] == a.size()) {
                    isValidB(b.get(i), j);
                }
            }
            String[] t = b.get(i).split(" ");
            if(answerList.size() != 1) {
                answer[i] = t[0] + " " + t[1] + " " + t[2] + " " + t[3] + " " + "?";
            } else {
                answer[i] = t[0] + " " + t[1] + " " + t[2] + " " + t[3] + " " + answerList.get(0);
            }
        }
        
        return answer;
    }
    
    public void isValidB(String exp, int digit) {
        String[] t = exp.split(" ");
        if(!isValidNumber(t[0], digit) || !isValidNumber(t[2], digit)) {
            return;
        }
        int n1 = Integer.parseInt(t[0], digit);
        int n2 = Integer.parseInt(t[2], digit);
        int result = t[1].equals("+") ? n1 + n2 : n1 - n2;
        
        String temp = Integer.toString(result, digit);
        if(answerList.isEmpty()) {
            answerList.add(temp);
        } else {
            for(int i = 0; i < answerList.size(); i++) {
                if(!answerList.get(i).equals(temp)) {
                    answerList.add(temp);
                    break;
                }
            }   
        }
    }
    
    public void isValidA(String exp, int digit) {
        String[] t = exp.split(" ");
        if(!isValidNumber(t[0], digit) || !isValidNumber(t[2], digit) || !isValidNumber(t[4], digit)) {
            return;
        }
        int n1 = Integer.parseInt(t[0], digit);
        int n2 = Integer.parseInt(t[2], digit);
        int result = t[1].equals("+") ? n1 + n2 : n1 - n2;

        if(result == Integer.parseInt(t[4], digit)) {
            int[] temp = list.get(digit);
            list.set(digit, new int[] {temp[0], temp[1] + 1});
        }
    }
    
    public static boolean isValidNumber(String n, int digit) {
        for(char c : n.toCharArray()) {
            int t = c - '0';
            if(t < 0 || t >= digit) {
                return false;
            }
        }
        return true;
    }
    
    public static int maxDigit(ArrayList<String> e) {
        int maxValue = 0;
        for(int i = 0; i < e.size(); i++) {
            for(char c : e.get(i).toCharArray()) {
                if(Character.isDigit(c)) {
                    maxValue = Math.max(maxValue, c - '0');
                }
            }
        }
        return maxValue + 1;
    }
}