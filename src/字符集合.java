import java.util.*;

public class 字符集合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            HashMap<Character, Boolean> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    System.out.print(s.charAt(i));
                    map.put(s.charAt(i), true);
                }
            }
            System.out.println();
        }
    }
}
