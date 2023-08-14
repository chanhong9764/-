import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5644 {
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return this.x + " " + this.y + " ";
		}
		@Override
		public boolean equals(Object obj) {
			return (this.x ==((Pos) obj).x && this.y == ((Pos)obj).y);
		}
	}
	
	static class charge extends Pos {
		int c;
		int p;
		public charge(int x, int y, int c, int p) {
			super(x, y);
			this.c = c;
			this.p = p;
		}
	}
	
	static int M, A;
	static ArrayList<Integer> moveA;
	static ArrayList<Integer> moveB;
	static ArrayList<Pos>[] chargePos;
	static Pos personA;
	static Pos personB;
	static charge[] charges;
	static int ans;
	
	static void getPos() {
		for(int i = 0; i < A; i++) {
			int nx = charges[i].x;
			int ny = charges[i].y - charges[i].c;
			int height = (2*charges[i].c) + 1;
			int square = 0;
			for(int j = 1; j <= height; j++) {
				for(int k = 0; k < (square * 2) + 1; k++) {
					int tx = nx + k;
					if(tx > 10 || tx < 1 || ny > 10 || ny < 1) {
						continue;
					}
					chargePos[i].add(new Pos(tx, ny));
				}
				ny += 1;
				if(j > height / 2) {
					nx += 1;
					square -= 1;
				} else {
					nx -= 1;
					square += 1;
				}
			}
		}
	}
	
	static void opCharge() {
		int[] dx = {0, 0, 1, 0, -1};
		int[] dy = {0, -1, 0, 1, 0};
		
		// 초기값 처리
		charging();
		
		for(int i = 0; i < M; i++) {
			int opA = moveA.get(i);
			int opB = moveB.get(i);
			
			personA.x += dx[opA];
			personA.y += dy[opA];

			personB.x += dx[opB];
			personB.y += dy[opB];
			
			charging();
		}
		
	}
	
	static void charging() {	
		int[] areaA = new int[A];
		int[] areaB = new int[A];
		
		for(int i = 0; i < A; i++) {
			if(chargePos[i].contains(personA)) {
				areaA[i] = charges[i].p;
			}
			if(chargePos[i].contains(personB)) {
				areaB[i] = charges[i].p;
			}
		}
		int maxValue = 0;

		for(int i = 0; i < A; i++) {
			for(int j = 0; j < A; j++) {
				if(i == j) {
					maxValue = Math.max(maxValue, areaA[i]);
					maxValue = Math.max(maxValue, areaB[j]);
				} else {
					maxValue = Math.max(maxValue, areaA[i] + areaB[j]);
				}
			}
		}
		ans += maxValue;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new ArrayList<>();
			moveB = new ArrayList<>();
			personA = new Pos(1, 1);
			personB = new Pos(10, 10);
			charges = new charge[A];
			chargePos = new ArrayList[A];
			ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				moveA.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				moveB.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < A; i++) {
				chargePos[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				charges[i] = new charge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			getPos();
			opCharge();

			System.out.println("#" + tc + " " + ans);
		}
	}
}
