import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        String input;
        int cnt = 0;
        while(sc.hasNext()) {
            input = sc.nextLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(String key : keySet) {
            System.out.printf("%s %.4f\n", key, ((double) map.get(key) / (double) cnt) * 100);
        }
    }
}
