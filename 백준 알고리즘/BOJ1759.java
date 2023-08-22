import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int L, C;
	static ArrayList<String> dictionary;
	static ArrayList<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
	static String[] sel;
	static boolean[] visited;

	static void dfs(int depth, int cnt) {
		if (cnt == L) {
			int vowelCount = 0;
			int consonantCount = 0;
			ArrayList<String> temp = new ArrayList<>();
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					String input = dictionary.get(i);
					if(vowel.contains(input)) {
						vowelCount++;
					} else {
						consonantCount++;
					}
					temp.add(dictionary.get(i));
				}
			}
			if(vowelCount >= 1 && consonantCount >= 2) {
				for(int j = 0; j < L; j++) {
					System.out.print(temp.get(j));
				}
				System.out.println();
			}
			return;
		}

		for (int i = depth; i < dictionary.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		sel = new String[L];
		dictionary = new ArrayList<>();
		visited = new boolean[C];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			dictionary.add(st.nextToken());
		}
		Collections.sort(dictionary);
		dfs(0, 0);
	}
}
