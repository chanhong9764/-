import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        dfs(0, 0, 0, false, 1);
        System.out.println(answer);
    }

    public static void dfs(int idx, int mo, int ja, boolean l, long count) {
        if(mo >= 3 || ja >= 3) return;
        if(idx == input.length()) {
            if(l) answer += count;
            return;
        }
        char t = input.charAt(idx);
        if(t == '_') {
            dfs(idx + 1, mo + 1, 0, l, count * 5);
            dfs(idx + 1, 0, ja + 1, l, count * 20);
            dfs(idx + 1, 0, ja + 1, true, count);
        } else {
            if(t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U') {
                dfs(idx + 1, mo + 1, 0, l, count);
            } else {
                if(t == 'L') dfs(idx + 1, 0, ja + 1, true, count);
                else dfs(idx + 1, 0, ja + 1, l, count);
            }
        }
    }
}