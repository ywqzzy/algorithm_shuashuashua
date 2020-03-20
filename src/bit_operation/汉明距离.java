package bit_operation;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int res = x^y;
        int cnt = 0;
        while(res != 0) {
            cnt += res & 1;
            res = res >> 1;
        }
        return cnt;
    }
}
