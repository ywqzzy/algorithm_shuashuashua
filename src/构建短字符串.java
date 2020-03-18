import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 构建短字符串 {
    // how to dp?????  brute force!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        Map<Character,Integer> map = new HashMap<>();
        boolean flag = true;
        int len = strs[1].length();
        for(int i=0;i<len;i++) {
            if(map.containsKey(strs[1].charAt(i))) {
                map.put(strs[1].charAt(i),map.get(strs[1].charAt(i))+1);
            }else map.put(strs[1].charAt(i),1);
        }
        len = strs[0].length();
        for(int i=0;i<len;i++) {
            if(map.containsKey(strs[0].charAt(i))) {
                if(map.get(strs[0].charAt(i)) > 0) map.put(strs[0].charAt(i),map.get(strs[0].charAt(i))-1);
                else {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("true");
        else System.out.println("false");
    }
}
