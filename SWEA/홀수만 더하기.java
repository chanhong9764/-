import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
         	int answer = 0;
            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                if (number % 2 == 1) {
                    answer += number;
                }
            }
            System.out.println("#" + tc +" "+ answer);
        }
	}
}