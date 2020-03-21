package string;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        char[] c = s.toCharArray();
        reverse(c, 0, s.length() - 1);
        reverse(c, 0, s.length() - n - 1);
        reverse(c, s.length() - n, s.length() - 1);
        return String.valueOf(c);
    }

    public void reverse(char[] carr, int start, int end) {
        while(start < end) {
            swap(carr, start, end);
            start++;
            end--;
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
