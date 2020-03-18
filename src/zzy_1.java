import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class Mode{
    int time;
    int weight;
    public Mode(int time,int weight){
        this.time = time;
        this.weight = weight;
    }
}
public class zzy_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-- > 0){
            List<Mode> modeList = new LinkedList<>();
            int k = Integer.parseInt(sc.nextLine().trim());
            String[]tmp = sc.nextLine().trim().split(" ");
            for(int i = 0;i < tmp.length;i += 3){
                int time = Integer.parseInt(tmp[i + 1]);
                int weight = Integer.parseInt(tmp[i + 2]);
                Mode mode = new Mode(time,weight);
                modeList.add(mode);
            }
            helper(modeList,k);
        }
    }
    public static void  helper(List<Mode>modeList,int k){
        modeList.sort(new Comparator<Mode>() {
            @Override
            public int compare(Mode o1, Mode o2) {
                if (o1.weight == o2.weight) return o1.time - o2.time;
                return o2.weight - o1.weight;
            }
        });
        int time = 0;
        int sum = 0;
        int count = 0;
        for(int i = 0;i < modeList.size();i++){
            Mode mode = modeList.get(i);
            if(mode.time > time){
                sum += mode.weight;
                time += 1;
                count++;
            }
        }
        System.out.println(count+" "+sum);
    }
}