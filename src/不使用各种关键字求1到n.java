public class 不使用各种关键字求1到n {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumNums(n-1)) > 0);
        return sum;
    }
}
