package sort;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String [] ss = new String[nums.length];
        int i = 0;
        for(int num: nums) ss[i++] = String.valueOf(num);
        Arrays.sort(ss, (s1, s2)->(s1+s2).compareTo(s2+s1));
        String res = "";
        for(String s: ss) res+=s;
        return res;
    }
}
