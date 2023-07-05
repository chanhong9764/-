import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Solution
{
    private static boolean row_col(int[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(puzzle[i][j]);
                col.add(puzzle[j][i]);
            }
            for (int j = 1; j <= 9; j++) {
                if (!row.contains(j) || !col.contains(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean square_check(int[][] puzzle) {
        for (int i = 0; i < 9; i += 3) {
            List<Integer> square = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    square.add(puzzle[i+j][k]);
                }
            }
            for (int j = 1; j <= 9; j++) {
                if (!square.contains(j)) {
                    return false;
                }
            }
        }
        return true;
    }

	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st;
            int[][] puzzle = new int[9][9];
            
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = row_col(puzzle) && square_check(puzzle) ? 1 : 0;
            System.out.println("#" + tc + " " + answer);
        }
	}
}