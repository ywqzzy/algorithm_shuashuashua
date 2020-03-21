package double_pointer;

public class 盛最多水的容器 {

    // 向内移动短板
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int mx = 0;
        while(start < end) {
            if(height[start] < height[end]) {
                mx = Math.max(mx, (end-start)* height[start]);
                start ++;
            } else {
                mx = Math.max(mx, (end-start)*height[end]);
                end --;
            }
        }
        return mx;
    }
}
