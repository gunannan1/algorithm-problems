package bishi;


import java.util.ArrayList;
import java.util.Scanner;

public class Q19 {
    ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k= sc.nextInt();
        Q19 q19=new Q19();
        ArrayList<ArrayList<Integer>> res=q19.FindPath(0,n,k+1);
        for(Integer i:res.get(0)){
            if(i!=0){
                if(i>0){
                    System.out.println(Math.abs(i)+" +");

                }
                else {
                    System.out.println(Math.abs(i)+" -");
                }

            }
        }


    }

    public ArrayList<ArrayList<Integer>> FindPath(int val, int n,int k) {
        if(k<=0){
            return paths;
        }

        path.add(val);
        n-=val;
        k-=1;
        if(n==0 && k==0){
            paths.add(new ArrayList<Integer>(path));
        }

        FindPath(2*Math.abs(val), n,k);
        FindPath(-2*Math.abs(val), n,k);
        FindPath(2*Math.abs(val)+1, n,k);
        FindPath(-(2*Math.abs(val)+1), n,k);


        path.remove(path.size()-1);
        return paths;

    }
}
