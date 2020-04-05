package 双周赛23;

public class 圆和矩形是否有重叠 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double w = x2 - x1;
        double h = y2 - y1;
        double halfW = w / 2;
        double halfH = h / 2;
        double recX = x1 + halfW;
        double recY = y1 + halfH;
        double rectRadius = Math.sqrt(halfH*halfH + halfW*halfW);
        double dist = Math.sqrt(((double)x_center - recX)*((double)x_center - recX) + ((double)y_center-recY) * ((double)y_center-recY));
        if(dist > rectRadius + radius) return false;
        return true;
    }
}
