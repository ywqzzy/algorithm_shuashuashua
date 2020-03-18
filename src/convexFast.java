import java.util.*;

class ConvexFast {
    public static class Points {
        private int x;
        private int y;
        Points(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n--!=0) {
            int cnt = sc.nextInt();
            ArrayList<Points> TotalList = new ArrayList<Points>();

            for (int i = 0; i < cnt; i++) {
                TotalList.add(new Points(sc.nextInt(), sc.nextInt()));
            }
            SortListBaseX(TotalList);
            ArrayList<Points> ResultList = new ArrayList<Points>();
            GetResultList(ResultList, TotalList);


            ArrayList<Points> Result = new ArrayList<Points>();
            for (int i = 0; i < ResultList.size(); i++) {
                if (!Result.contains(ResultList.get(i)))
                    Result.add(ResultList.get(i));
            }

            for (int i = 0; i < Result.size(); i++) {
                if(i != Result.size() - 1)
                    System.out.print(Result.get(i).getX()+","+Result.get(i).getY()+", ");
                else System.out.println(Result.get(i).getX()+","+Result.get(i).getY());
            }
        }
    }

    public static ArrayList<Points> GetResultList (ArrayList<Points> ResultList,ArrayList<Points> TotalList){

        ResultList.add(TotalList.get(0));
        ResultList.add(TotalList.get(TotalList.size()-1));
        TotalList.remove(0);
        TotalList.remove(TotalList.size()-1);

        ArrayList<Points> LeftList=new ArrayList<Points>(SideList(ResultList.get(0),ResultList.get(1),TotalList,"left"));//Left Side List
        FindConvexHull(ResultList.get(0),ResultList.get(1),LeftList,ResultList);

        ArrayList<Points> RightList=new ArrayList<Points>(SideList(ResultList.get(0),ResultList.get(1),TotalList,"right"));//Right Side List
        FindConvexHull(ResultList.get(1),ResultList.get(0),RightList,ResultList);

        return ResultList;
    }

    //Sorting a point array based on the value of X-coodinator.
    public static ArrayList<Points> SortListBaseX (ArrayList<Points> SortList){
        Comparator<Points> comparator = new Comparator<Points>(){

            public int compare(Points a, Points b) {
                if (a.x!=b.x){
                    return a.x-b.x;
                }
                else{
                    return a.y-b.y;
                }
            }
        };
        Collections.sort(SortList,comparator);
        return SortList;
    }

    //Find ConvexHull based on Deviding and Conquer recurrsively.
    public static void FindConvexHull(Points a, Points b, ArrayList<Points> SideList, ArrayList<Points> ResultList){
        Iterator<Points> it = SideList.iterator();
        ArrayList<Points> LeftSideList=new ArrayList<Points>();
        ArrayList<Points> RightSideList=new ArrayList<Points>();

        Points MaxPoint=null;
        int max=0;

        while(it.hasNext()){
            Points temp=it.next();
            int compute= compute(temp,a,b);

            if (compute>max){
                MaxPoint=temp;
            }
        }

        if (MaxPoint!=null){
            ResultList.add(MaxPoint);
            SideList.remove(MaxPoint);
            Iterator<Points> it2 = SideList.iterator();
            while (it2.hasNext()){
                Points temp=it2.next();
                if (onLeft(temp,a,MaxPoint)==1){
                    LeftSideList.add(temp);
                }
                if (onLeft(temp,MaxPoint,b)==1){
                    RightSideList.add(temp);
                }
            }
            FindConvexHull(a,MaxPoint,LeftSideList,ResultList);
            FindConvexHull(MaxPoint,b,RightSideList,ResultList);
        }
    }

    //Devide the whole dot set as two parts.
    public static ArrayList<Points> SideList(Points a, Points b, ArrayList<Points> TotalList,String side){

        Iterator<Points> it = TotalList.iterator();
        ArrayList<Points> LeftList=new ArrayList<Points>();
        ArrayList<Points> RightList=new ArrayList<Points>();

        while(it.hasNext()){
            Points temp=it.next();
            if (onLeft(temp,a,b)==1){
                LeftList.add(temp);
            }
            else if (onLeft(temp,a,b)==2){
                RightList.add(temp);
            }
        }
        if (side.equals("left")){
            return LeftList;
        }
        else if (side.equals("right")){
            return RightList;
        }
        else{
            return null;
        }
    }

    //Determine if the point is on the left/right of the line, if left ->1, right ->2, on the line ->3.
    public static int onLeft(Points target,Points p1,Points p2){

        int compute=compute(target,p1,p2);
        if(compute > 0)
            return 1;//left
        else if(compute < 0)
            return 2;//right
        else
            return 3;//on the line
    }
    //Compute the vector product of two edges of a triangle.
    public static int compute(Points target, Points p1, Points p2){
        int x1 = p1.x,y1 = p1.y;
        int x2 = p2.x,y2 = p2.y;
        int x3 = target.x,y3 = target.y;
        int compute = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
        return compute;
    }
}
