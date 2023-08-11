import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ANS = Integer.MAX_VALUE, map[][];
	static Offer[] offer;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("test1"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		offer = new Offer[K];
		
		//맵 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			offer[i] = new Offer(r, c, s);
		}
		
		used = new int[K];
		history = new int[K];
		por(0);
		System.out.println(ANS);
	}
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	private static void rot(Offer offer) {
		int r = offer.r;
		int c = offer.c;
		int size = offer.s;
		
		int[][] v = new int[N][M];
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for (int i = c - size; i < c + size; i++) {
			copy[r - size][i + 1] = map[r - size][i];
		}
		for (int i = r - size; i < r + size; i++) {
			copy[i + 1][c + size] = map[i][c + size];
		}
		for (int i = c + size; i > c - size; i--) {
			copy[r+size][i - 1] = map[r+size][i];
		}
		for (int i = r + size; i >  r - size; i--) {
			copy[i - 1][c - size] = map[i][c - size];
		}

		map = copy;
	}
	
	static int[] used = new int[K];
	static int[] history = new int[K];
	private static void por(int depth) {
		if (depth == K) {
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			for (int r = 0; r < K; r++) {
				Offer tmp = offer[history[r]];
				for (int i = 1; i <= tmp.s; i++) {
					rot(new Offer(tmp.r, tmp.c , i));
					
				}
				
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < map.length; i++) {
				int sum = 0;				
				for (int j = 0; j < map[i].length; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			map = copy;
			ANS = Math.min(ANS, min);

			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (used[i] == 1) continue;
			used[i] = 1;
			history[depth] = i;
			por(depth+1);
			used[i] = 0;
		}
	}


	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	static class Offer {
		int r, c , s;
		
		Offer (int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
