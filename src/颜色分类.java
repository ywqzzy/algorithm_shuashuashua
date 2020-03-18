public class 颜色分类 {

    public void sortColorsWrong(int[] nums) {
        if(nums == null) return;
        int p0 = 0, p2 = nums.length - 1;
        int last10 = -1, last12 = 0;
        while(p0 != p2) {
            if(nums[p0] == 0) {
                if(last10 != -1) {
                    nums[last10] = 0;
                    nums[p0] = last10;
                    last10 = p0;
                }
                p0++;
            } else if(nums[p0] == 1){
                last10 = p0;
                p0++;
            } else if(nums[p0] == 2) {
                int temp = nums[p2];
                nums[p2] = nums[p0];
                nums[p0] = nums[p2];
            }
            if(nums[p2] == 2) {
                if(last12 != -1) {
                    nums[last12] = 0;
                    nums[p2] = last12;
                    last12 = p2;
                }
                p2--;
            } else if(nums[p2] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[p2];
                nums[p2] = temp;
            } else if(nums[p2] == 1) {
                last12 = p2;
                p2 --;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    // 三指针
    public void sortColors(int[] nums) {
        int p0 = 0, tempIdx = 0, p2 = nums.length - 1;

        while(tempIdx <= p2) {
            if(nums[tempIdx] == 0) {
                int temp = nums[p0];
                nums[p0] = 0;
                p0++;
                nums[tempIdx++] = temp;
            } else if(nums[tempIdx] == 2) {
                int temp = nums[p2];
                nums[p2] = 2;
                p2--;
                nums[tempIdx] = temp;
            } else {
                tempIdx ++;
            }
        }
    }

    public static void main(String[] args) {
        颜色分类 main = new 颜色分类();
        main.sortColors(new int[] {2,0,2, 1, 1, 0});
    }
}
