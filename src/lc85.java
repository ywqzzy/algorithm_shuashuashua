import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class lc85 {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[]height = new int[matrix[0].length];
        int resultMax = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            resultMax = Math.max(resultMax,helper(height));
        }
        return resultMax;
    }

    public static int helper(int[]height) {
        int n = height.length;
        //arrayList 可以指定大小
        List<Integer> left = new ArrayList<Integer>(n);
        List<Integer> right = new ArrayList<Integer>(n);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++) {
            while(stack.size() > 0 && height[stack.peek()] >= height[i]) stack.pop();
            if(stack.empty()) left.add(i, -1);
            else left.add(i,stack.peek());
            stack.push(i);
        }
        while(stack.size() > 0) stack.pop();
        for(int i = n - 1;i >= 0;i--) {
            while(stack.size() > 0 && height[stack.peek()] >= height[i]) stack.pop();
            if(stack.empty()) right.add(i,n);
            else right.add(i,stack.peek());
            stack.push(i);
        }
        int res = 0;
        for(int i = 0;i < n;i++) {
            res = Math.max(res,height[i] * (right.get(i) - left.get(i) - 1));
        }
        return res;

    }

}

