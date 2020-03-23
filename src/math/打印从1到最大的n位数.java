package math;

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += 9 * Math.pow(10, i);
        }
        int []res = new int[cnt];

        for(int i = 0; i < cnt; i++) res[i] = i + 1;
        return res;
    }
}
