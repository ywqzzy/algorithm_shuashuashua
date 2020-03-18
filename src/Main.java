import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void parse(String s) {
        int len = s.length();
        String res = "";
        char last = '/';
        int curlen = 0;
        boolean isFolongow = false;
        boolean isDel = false;
        int delnum = 0;
        int delfolongow = 0;
        for(int i = 0;i<len;i++) {
            if(i == 0) {
                curlen = 1;
                last = s.charAt(i);
                res += last;
            } else {
                if(s.charAt(i) == last) {
                    curlen ++;
                    if(isFolongow && curlen == 2) {
                        isFolongow = false;
                        isDel = true;
                        delnum++;
                        delfolongow++;
                    } else if(curlen <= 2) {
                        res += last;
                    }else {
                        delnum++;
                        isDel = true;
                    }
                } else {
                    if(curlen == 2) {
                        isFolongow = true;
                        if(isDel) isFolongow = false;
                        isDel = false;
                        curlen = 1;
                        last = s.charAt(i);
                        res += last;
                    }else {
                        curlen = 1;
                        isFolongow = false;
                        last = s.charAt(i);
                        res += last;
                    }
                }
            }
        }
        if(delnum == 0 || delnum == delfolongow) {
            System.out.println(res);
        } else {
            parse(res);
        }
    }


    public static void parseTrue(String s) {
        String res = "";
        int len = s.length();
        for(int i = 0;i<len;i++) {
            char c = s.charAt(i);
            int reslen = res.length();
            if(res.length() < 2) {
                res += c;
                continue;
            }

            if(c == res.charAt(res.length() - 1) && c == res.charAt(res.length()-2)) continue;
            if(res.length() > 2) {
                if (c == res.charAt(reslen - 1) && res.charAt(reslen - 2) == res.charAt(reslen - 3)) {
                    continue;
                }
            }
            res+=c;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> strs = new ArrayList<>();

        for(int i = 0;i<n;i++) {
            strs.add(sc.nextLine());
            parse(strs.get(i));
        }
    }
}
