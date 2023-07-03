import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxValue = 0;
            
            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                if (number > maxValue) {
                    maxValue = number;
                }
            }
            System.out.println("#" + tc + " " + maxValue);
        }
	}
}