import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20187 {
	static ArrayList<String> op = new ArrayList<>();
	static int K, h;
	static int[][] map;
	
	static int getHole(int num, String type) {
		int value = -1;
		if(type.equals("R") || type.equals("L")) {
			switch(num) {
				case 0: value = 1; break;
				case 1: value = 0; break;
				case 2: value = 3; break;
				default: value = 2;
			}
		} else if (type.equals("D") || type.equals("U")) {
			switch(num) {
				case 0: value = 2; break;
				case 1: value = 3; break;
				case 2: value = 0; break;
				default: value = 1;
			}
		}	
		return value;
	}

	static void recursive(int k, int rowStart, int rowEnd, int colStart, int colEnd) {
		if(k == op.size()) {
			map[rowStart][colStart] = h;
			return;
		}
		String operation = op.get(k); 
				
		if(operation.equals("D")) {
			recursive(k + 1, ((rowStart + rowEnd) / 2) + 1, rowEnd, colStart, colEnd);
			for(int i = rowStart; i <= (rowStart + rowEnd) / 2; i++) {
				for(int j = colStart; j <= colEnd; j++) {
					map[i][j] = getHole(map[(rowStart + rowEnd) - i][j], "D");
				}
			}
		} else if(operation.equals("U")) {
			recursive(k + 1, rowStart, ((rowStart + rowEnd) / 2), colStart, colEnd);
			for(int i = (rowStart + rowEnd) / 2 + 1; i <= rowEnd; i++) {
				for(int j = colStart; j <= colEnd; j++) {
					map[i][j] = getHole(map[(rowStart + rowEnd) - i][j], "U");
				}
			}
		} else if(operation.equals("R")) {
			recursive(k + 1, rowStart, rowEnd, ((colStart + colEnd) / 2) + 1, colEnd);
			for(int i = rowStart; i <= rowEnd; i++) {
				for(int j = colStart; j <= (colStart + colEnd) / 2; j++) {
					map[i][j] = getHole(map[i][(colStart + colEnd) - j], "R");
				}
			}
		} else {
			recursive(k + 1, rowStart, rowEnd, colStart, ((colStart + colEnd) / 2));
			for(int i = rowStart; i <= rowEnd; i++) {
				for(int j = (colStart + colEnd) / 2 + 1; j <= colEnd; j++) {
					map[i][j] = getHole(map[i][(colStart + colEnd) - j], "L");
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * K; i++) {
			op.add(st.nextToken());
		}
		h = Integer.parseInt(br.readLine());
		int size = (int) Math.pow(2, K);
		
		map = new int[size][size];
		
		recursive(0, 0, size - 1, 0, size - 1);
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}