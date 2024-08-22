import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] aGroup = new int[a];
            int[] bGroup = new int[b];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < a; i++) {
                aGroup[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < b; i++) {
                bGroup[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bGroup);
            int answer = 0;
            for(int i = 0; i < a; i++) {
                answer += binary_search(aGroup[i], bGroup);
            }
            System.out.println(answer);
        }
    }

    public static int binary_search(int value, int[] group) {
        int start = 0;
        int end = group.length - 1;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            if(value > group[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
