package bit_operation;

public class 交换数字 {
    public int[] swapNumbers1(int[] numbers) {
        if(numbers==null || numbers.length < 2) return numbers;
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
    public int[] swapNumbers(int[] numbers) {
        if(numbers==null || numbers.length < 2) return numbers;
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] += numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }
}
