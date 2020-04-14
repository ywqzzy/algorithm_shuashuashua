package string;

public class 反转单词顺序 {
    public String reverseWords1(String s) {
        String[] a = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = a.length - 1; i >= 0; i--) {
            if(!a[i].equals("")) {
                sb.append(a[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    // 两次反转
    public String reverseWords(String s) {
        int len = s.length();
        char []sarr = s.toCharArray();
        int curIdx = 0;
        for(int i = 0; i < len; i++) {
            while(i < len && sarr[i] == ' ') i++;
            if(i == len) break;
            int end = i;
            while(end < len && sarr[end] !=' ') end++;
            reverse(sarr, i, end-1);
            if(curIdx > 0) sarr[curIdx++] = ' ';
            while(i < end) sarr[curIdx++] = sarr[i++];
        }
        reverse(sarr, 0, curIdx-1);
        return String.valueOf(sarr, 0, curIdx);
    }

    public void reverse(char[] ch,int start,int end){
        if(ch==null||ch.length==0){
            return;
        }
        while(start<end) {
            Character temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        反转单词顺序 main = new 反转单词顺序();
        System.out.println(main.reverseWords("the sky is blue"));
    }
}
