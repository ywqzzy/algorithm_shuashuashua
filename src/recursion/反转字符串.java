package recursion;

public class 反转字符串 {
    public void  reverseString(char[] s) {
        swap(s, 0, s.length-1);
    }
    public void swap(char[]s, int left, int right) {
        if(left >= right) return;
        char tmp = s[left];
        s[left] = s[right];
        left ++;
        s[right] = tmp;
        right--;
        swap(s, left, right);
    }

    public static void main(String[] args) {
        反转字符串 main = new 反转字符串();
        char []tmp = "adhkjahjdkhakjd".toCharArray();
        main.reverseString(tmp);
        System.out.println(tmp);

    }
}
