import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            Character prev = input.charAt(0);
            map.put(input.charAt(0), 0);
            boolean isValid = true;
            for(int j = 1; j < input.length(); j++) {
                if(prev != input.charAt(j)) {
                    if(map.get(input.charAt(j)) == null) {
                        map.put(input.charAt(j), 0);
                    } else {
                        isValid = false;
                        break;
                    }
                }
                prev = input.charAt(j);
            }
            if(isValid) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
