import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static ArrayList<Point> ZERO, Virus;
	static int ans = 0;
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("test1"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		check();
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void check() {
		ArrayDeque<Point> p = new ArrayDeque<Main.Point>();
		int[][] v = new int[N][M];
		p.add(new Point(0, 0));
		v[0][0] = 1;
		
		while(!p.isEmpty()) {
			Point t = p.pop();
			
			for(int i = 0; i < 4; i++) {
				int tr = t.r + dr[i];
				int tc = t.c + dc[i];
						
				if(tr >= N || tr < 0 || tc >= M || tc < 0 || v[tr][tc] > 0 || map[tr][tc] == 0) {
					continue;
				}
				v[tr][tc] = v[t.r][t.c] + 1;
				p.add(new Point(tr, tc));
			}
		}
		System.out.println(v[N - 1][M - 1]);
	}
}
