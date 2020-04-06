package arr;

import javax.xml.bind.SchemaOutputResolver;

public class 二十六进制加法 {
    String add(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0; // 表示进位

        if(arr1.length > arr2.length) {
            char[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int len1 = arr1.length, len2 = arr2.length;
        // 先把公共部分加完
        // arr1 短  arr2 长
        for(int i = len1 - 1; i>=0; i--) {
            int temp = arr1[i] - 'A' + arr2[i + len2 - len1] - 'A' + carry; // len2 - len1 是为了对齐
            if(temp > 25) {
                sb.append((char)(temp % 26+'A'));
                carry = 1;
            } else {
                sb.append((char)(temp +'A'));
                carry = 0;
            }
        }
        for(int i = len2 - len1 - 1; i >= 0; i--) {
            int temp = arr2[i] - 'A' + carry;
            if(temp > 25) {
                sb.append((char)(temp % 26+'A'));
                carry = 1;
            } else {
                sb.append((char)(temp +'A'));
                carry = 0;
            }
        }
        if(carry > 0) {
            sb.append((char)(carry+'A'));
        }
        sb.reverse(); // 是从低位一个个数字加的

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != 'A') {
                return sb.substring(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        二十六进制加法 main = new 二十六进制加法();
        System.out.println(main.add("AAAADH", "BCE"));
        System.out.println(main.add("DRW", "UHD"));
        System.out.println(main.add("D","AAAAA"));
    }
}
