import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int w = 0;
            int b = 0;
            String curr = br.readLine();
            String ans = br.readLine();
            for(int j = 0; j < N; j++) {
                if(curr.charAt(j) != ans.charAt(j)) {
                    if(curr.charAt(j) == 'W') {
                        w++;
                    } else {
                        b++;
                    }
                }
            }
            System.out.println(w > b ? w : b);
        }
    }
}
