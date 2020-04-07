package arr;

public class 三十六进制加法 {
    int carry = 0;  // 表示进位

    String add(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(arr1.length > arr2.length) {
            char[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int len1 = arr1.length, len2 = arr2.length;
        // 先把公共部分加完
        // arr1 短  arr2 长
        for(int i = len1 - 1; i>=0; i--) {
            int temp = calSum(arr1[i], arr2[i + len2 - len1]);
            appendSb(sb, temp);
        }
        for(int i = len2 - len1 - 1; i >= 0; i--) {
            int temp;
            if(carry == 1) temp = calSum(arr2[i], '1');
            else temp = calSum(arr2[i], '0');
            appendSb(sb, temp);
        }
        if(carry > 0) sb.append((char)(carry+'0'));

        sb.reverse(); // 是从低位一个个数字加的
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '0') return sb.substring(i);
        }
        return "";
    }

    int calSum(char c1, char c2) {
        int num1,num2;
        if(c1 >= '0' && c1 <= '9') num1 = c1 - '0';
        else num1 = c1 - 'A' + 10;

        if(c2 >= '0' && c2 <= '9') num2 = c2 - '0';
        else num2 = c2 - 'A' + 10;
        return num1 + num2;
    }

    void appendSb(StringBuilder sb, int temp) {
        char tc;
        if(temp > 36) {
            int t = temp % 36;
            if(t >=0 && t <= 9)  tc = (char)('0' + t);
            else tc = (char) ('A' + t - 10);
            sb.append(tc);
            carry = 1;
        } else {
            if(temp >=0 && temp <= 9) tc = (char)('0' + temp);
            else tc = (char) ('A' + temp - 10);
            sb.append(tc);
            carry = 0;
        }
    }

    public static void main(String[] args) {
        三十六进制加法 main = new 三十六进制加法();
        System.out.println(main.add("A1", "B2"));
    }
}

