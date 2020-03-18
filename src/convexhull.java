//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class convexhull {
//    public static class Point {
//        private int x;
//        private int y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//        public int getX(){
//            return x;
//        }
//        public int getY(){
//            return y;
//        }
//    }
//    public static Point[] getConvexPoint(Point[] A){
//        Point[] result = new Point[A.length];
//        int len = 0;
//        for(int i = 0;i < A.length;i++){
//            for(int j = 0;j < A.length;j++){
//                if(j == i)  continue; // 必须是直线
//                int[] judge = new int[A.length];
//                for(int k = 0;k < A.length;k++){
//                    int a = A[j].getY() - A[i].getY();
//                    int b = A[i].getX() - A[j].getX();
//                    int c = (A[i].getX())*(A[j].getY()) - (A[i].getY())*(A[j].getX());
//                    judge[k] = a*(A[k].getX()) + b*(A[k].getY()) - c;
//                }
//                if(judgeArray(judge)){  // 如果点均在直线的一边,则相应的A[i]是凸包中的点
//                    result[len++] = A[i];
//                    break;
//                }
//            }
//        }
//        Point[] res = new Point[len];
//        for(int i = 0;i < len; i++) res[i] = result[i];
//        return res;
//    }
//
//    public static boolean judgeArray(int[] arr){
//        boolean flag = false;
//        int lenLeft = 0, lenRight = 0;
//        for(int i = 0;i < arr.length;i++) if(arr[i] >= 0) lenLeft++;
//        for(int j = 0;j < arr.length;j++) if(arr[j] <= 0) lenRight++;
//        if(lenLeft == arr.length || lenRight == arr.length) flag = true;
//        return flag;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while(n--!=0) {
//            int cnt = sc.nextInt();
//            Point[] points = new Point[cnt];
//            for(int i = 0; i < cnt; i++) {
//                points[i] = (new Point(sc.nextInt(), sc.nextInt()));
//            }
//            Point[] result = getConvexPoint(points);
//            for(int i = 0;i < result.length;i++)
//                if(i != result.length - 1)
//                    System.out.print(result[i].getX()+","+result[i].getY()+", ");
//                else System.out.println(result[i].getX()+","+result[i].getY());
//        }
//    }
//}

