package recursion;

public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        if(num <= 9) return 1;
        int lastTwo = num % 100;
        if(lastTwo <= 9 || lastTwo >= 26)  return translateNum(num / 10);
        else return translateNum(num / 10) + translateNum(num / 100);
    }

    // TODO DP
}
