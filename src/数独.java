import java.util.List;
import java.util.Scanner;

public class 数独 {
    static boolean isOk;
    static int [][]mmap = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        isOk=false;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++) mmap[i][j]=sc.nextInt();
        solve(0,0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print((j == 0 ? "" : " ") + mmap[i][j]);
            }
            System.out.println();
        }
    }
    private static void solve(int x, int y) {
        if(x==9&&y==0) {
            isOk=true;
            return;
        }
        int tempY=y+1,tempX=x;
        if(tempY==9) {
            tempY=0;
            tempX+=1;
        }
        if(mmap[x][y]!=0) solve(tempX,tempY);
        else {
            for (int i=1;i<=9;i++) {
                mmap[x][y]=i;
                if(check(x,y)) {
                    solve(tempX,tempY);
                    if(isOk) return;
                }
                mmap[x][y]=0;
            }
        }
    }
    static boolean check(int x,int y) {
        for(int i=0;i<9;i++) {
            if(i!=x) {
                if(mmap[i][y]==mmap[x][y]) return false;
            }
            if(i!=y) {
                if(mmap[x][i]==mmap[x][y]) return false;
            }
        }
        int row=(x/3)*3;
        int col=(y/3)*3;
        for(int i=row;i<row+3;i++) {
            for (int j=col;j<col+3;j++) {
                if (i!=x&&j!= y) {
                    if (mmap[i][j] == mmap[x][y]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
