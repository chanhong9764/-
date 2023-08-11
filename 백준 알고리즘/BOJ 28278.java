import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("test1"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayDeque Q = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str.length == 2) {
				Q.add(Integer.parseInt(str[1]));
			}
			int op = Integer.parseInt(str[0]);
			if (op == 4) {
				if (Q.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
			}
			if (op == 3) {
				bw.write(Q.size()+"\n");
			}
			if (op == 2) {
				if (Q.size() == 0) bw.write("-1\n");
				else bw.write(Q.removeLast()+"\n");
			}
			if (op == 5) {
				if (Q.size() == 0) bw.write("-1\n");
				else bw.write(Q.peekLast()+"\n");
			}
		}
		bw.flush();
	
	}
	
}
