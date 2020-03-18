//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class 寻找两个有序数组的中位数 {
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double res = 0;
//        int m = nums1.length;
//        int n = nums2.length;
//        int heapSize = (m + n) / 2;
//        PriorityQueue<Integer> pqMin = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        PriorityQueue<Integer> pqMax = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for (int i = 0; i < m; i++) {
//            if(i < heapSize) {
//                pqMax.add(nums1[i]);
//                pqMin.add(nums2[i]);
//            }
//            if(i >= heapSize) {
//                pqMax.poll();
//                pqMin.poll();
//            }
//
//            if (pqMax == null)
//        }
//
//
//
//        return res;
//    }
//}
