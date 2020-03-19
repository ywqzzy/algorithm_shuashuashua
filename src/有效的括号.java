import java.util.Stack;

public class 有效的括号 {

    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char tc = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(tc);
            } else {
                if(tc == '(' || tc == '[' || tc=='{') {
                    stack.push(tc);
                } else if(stack.isEmpty()) {
                    return false;
                } else if(tc == ']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if(tc == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if(tc == '}') {
                    if(stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        有效的括号 main = new 有效的括号();

        System.out.println(main.isValid("([)"));
    }
}
