import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// max 选三个
// min 选两个
//max3为最大数
// max(max1*max2*max3, max3*min1*min2)
public class 最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++) nums.add(sc.nextInt());

        //        int a = nums.get(0);
//        int b = nums.get(1);
//        int c = nums.get(2);
//        List<Integer> tl = new ArrayList<>();
//        tl.add(a);tl.add(b);tl.add(c);
//        Collections.sort(tl);
//        int maxa=tl.get(0),maxb=tl.get(1),maxc=tl.get(2);
//        boolean ta=true,tb=true,tc=true;
//        for(int i=3;i<n;i++) {
//            int num = nums.get(i);
//            int ab = Math.abs(num);
//            if(ab > maxa && ab < maxb) {
//                maxa = ab;
//                if(ab != num) ta = false;
//            }
//            else if(ab>maxb && ab<maxc){
//                maxa = maxb;
//                maxb = ab;
//                if(ab!=num) tb= false;
//
//            }
//            else if(ab>maxc) {
//                maxa = maxb;
//                maxb = maxc;
//                maxc = ab;
//                if(ab!=num) tc = false;
//            }
//        }
//        //System.out.println(maxa+" "+maxb+" "+maxc);
//
    }
}
