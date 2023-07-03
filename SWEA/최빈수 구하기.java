import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        br.readLine();
        for (int T = 1; T <= 10; T++) {
            int tc = Integer.parseInt(br.readLine());
            int[] numbers = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            while (st.hasMoreTokens()) {
                numbers[Integer.parseInt(st.nextToken())]++;
            }
            int maxValue = 0;
            int answer = 0;
            for (int i = 0; i < 101; i++) {
                if (numbers[i] >= maxValue) {
                    maxValue = numbers[i];
                    answer = i;
                }
            }
            System.out.println("#" + T + " " + answer);
        }
	}
}