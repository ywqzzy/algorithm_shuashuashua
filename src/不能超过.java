import java.util.Arrays;
import java.util.Scanner;

public class 不能超过 {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,x;
        n = sc.nextInt();
        x = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int start = 0, end = n - 1;
        int removeCnt = 0;
        不能超过 main = new 不能超过();
        main.dfs(start, end, arr, removeCnt, x);
        System.out.println(res);
    }

    public void dfs(int start, int end, int []arr, int removeCnt, int x) {
        if(start >= end) return;
        if(arr[end] - arr[start] <= x) {
            res = Math.min(res, removeCnt);
            return;
        }
        int endMinus = arr[end] - arr[end - 1];
        int startMinus = arr[start + 1] - arr[start];
        removeCnt++;
        if(endMinus > startMinus) end--;
        else if(startMinus > endMinus) start++;
        else {
            dfs(start++, end, arr, removeCnt, x);
            dfs(start, end--, arr, removeCnt, x);
        }

        dfs(start, end, arr, removeCnt, x);
    }

}
