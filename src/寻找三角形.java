import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 寻找三角形 {
    static class Point{
        char c;
        int x;
        int y;
        int z;
    }
    public static double distance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y) + (p1.z-p2.z)*(p1.z-p2.z));
    }
    public static boolean checkColor(Point p1, Point p2, Point p3) {
        if (p1.c == p2.c && p1.c == p3.c) return true;
        else if (p1.c!=p2.c && p1.c!=p3.c && p2.c!=p3.c) return true;
        else return false;
    }
    public static boolean check(Point p1, Point p2, Point p3) {
        double d1 = distance(p1, p2);
        double d2 = distance(p1, p3);
        double d3 = distance(p2, p3);
        if (d1<(d2+d3) && d2<(d1+d3) && d3<(d1+d2) && d1>Math.abs(d2-d3) && d2>Math.abs(d1-d3) && d3>Math.abs(d1-d2))return true;
        return false;
    }
    public static double area(Point p1, Point p2, Point p3) {
        double a = distance(p1, p2);
        double b = distance(p1, p3);
        double c = distance(p2, p3);
        double p = (a + b + c) / 2;
        return  Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        for(int i = 0; i < n; i++){
            Point p = new Point();
            String[] t = sc.nextLine().split(" ");
            p.c = t[0].charAt(0);
            p.x = Integer.parseInt(t[1]);
            p.y = Integer.parseInt(t[2]);
            p.z = Integer.parseInt(t[3]);
            list.add(p);
        }
        double maxx = 0;
        double tmp = 0;
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++){
                    Point p1 = list.get(i);
                    Point p2 = list.get(j);
                    Point p3 = list.get(k);
                    if (check(p1,p2,p3) && checkColor(p1,p2,p3)) tmp = area(p1,p2,p3);
                    maxx = Math.max(maxx,tmp);
                }
            }
        }
        System.out.format("%.5f", maxx);
    }
}