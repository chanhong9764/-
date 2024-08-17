import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int answer = 1;
        String ts = s.concat(s);
        String tt = t.concat(t);

        if(ts.length() > tt.length()) {
            for(int i = 0; i < ts.length(); i++) {
                if(ts.charAt(i) != tt.charAt(i % tt.length())){
                    answer = 0;
                    break;
                }
            }
        } else {
            for(int i = 0; i < tt.length(); i++) {
                if(tt.charAt(i) != ts.charAt(i % ts.length())){
                    answer = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
