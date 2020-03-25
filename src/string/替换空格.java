package string;

public class 替换空格 {
    public String replaceSpace(String s) {
        int len = s.length();
        char []carr = s.toCharArray();
        for(char c: carr) {
            if(c == ' ') len += 2;
        }
        int idx = 0;
        char[] resc = new char[len];
        for(char c: carr) {
            if(c != ' ') resc[idx++] = c;
            else {
                resc[idx++] = '%';
                resc[idx++] = '2';
                resc[idx++] = '0';
            }
        }
        return new String(resc);
    }
}
