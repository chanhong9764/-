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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ZERO = new ArrayList<Point>();
		Virus = new ArrayList<Main.Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) ZERO.add(new Point(i, j));
				if (map[i][j] == 2) Virus.add(new Point(i, j));
				
			}
		}
		
		zeroLength = ZERO.size();	
		used = new int[zeroLength];
		history = new int[3];
		combi(0, 0);
		System.out.println(ans);
	}
	static int zeroLength;
	static int[] used;
	static int[] history;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void check() {
		int count = 0;
		ArrayDeque<Point> p = new ArrayDeque<Main.Point>();
		boolean[][] v = new boolean[N][M];
		for(int i = 0; i < Virus.size(); i++) {
			p.add(Virus.get(i));
			v[Virus.get(i).r][Virus.get(i).c] = true;
		}
	
		while(!p.isEmpty()) {
			Point t = p.pop();
			
			for(int i = 0; i < 4; i++) {
				int tr = t.r + dr[i];
				int tc = t.c + dc[i];
						
				if(tr >= N || tr < 0 || tc >= M || tc < 0 || v[tr][tc] || map[tr][tc] == 1 || map[tr][tc] == 2) {
					continue;
				}
				v[tr][tc] = true;
				p.add(new Point(tr, tc));
				count += 1;
			}
		}
		int c = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(v[i][j] == false && map[i][j] != 1) {
					c++;
				}
			}
		}
		ans = Math.max(ans, c);
	}
	
	static void combi(int depth, int k) {
		if(depth == 3) {
			Point[] p = new Point[3];
			
			for(int i = 0; i < 3; i++) { 
				p[i] = ZERO.get(history[i]);
			}
			for(int i = 0; i < 3; i++) {
				map[p[i].r][p[i].c] = 1;
			}
			check();
			for(int i = 0; i < 3; i++) {
				map[p[i].r][p[i].c] = 0;
			}
			return;
		}
		
		for(int i = k; i < zeroLength; i++) {
			if(used[i] == 1) {
				continue;
			}
			used[i] = 1;
			history[depth] = i;
			combi(depth + 1, i + 1);
			used[i] = 0;
		}
	}
}
