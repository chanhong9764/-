import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution
{
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        char[] number = numbers.toCharArray();
        int answer = 0;
        
        for (char value : number) { 
            answer += value - '0';
        }
        System.out.println(answer);
	}
}