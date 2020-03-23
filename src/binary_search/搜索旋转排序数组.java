package binary_search;


public class 搜索旋转排序数组 {

    // 可以的 知识盲区
    // 复杂度 O(logN)
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {  // 这个下标到底咋确定。。
               if(target >= nums[left] && target < nums[mid]) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
            } else {
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)/2;

        while(left <= right){
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){  //左边升序
                if(target >= nums[left] && target <= nums[mid]){//在左边范围内
                    right = mid-1;
                }else{//只能从右边找
                    left = mid+1;
                }

            }else{ //右边升序
                if(target >= nums[mid] && target <= nums[right]){//在右边范围内
                    left = mid +1;
                }else{//只能从左边找
                    right = mid-1;
                }

            }
            mid = left + (right-left)/2;
        }

        return -1;  //没找到
    }
}
