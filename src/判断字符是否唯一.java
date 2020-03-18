import java.util.HashSet;

public class 判断字符是否唯一 {
    public boolean isUnique(String astr) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < astr.length();i++) {
            if(set.contains(astr.charAt(i))){
                return false;
            }
            set.add(astr.charAt(i));
        }
        return true;
    }
}
