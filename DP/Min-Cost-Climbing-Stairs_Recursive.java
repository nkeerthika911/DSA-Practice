import java.util.*;

public class MyClass {
  public static int minCost(int stair,int[] cost){
      if(stair<=1) return 0;
      return Math.min(minCost(stair-1,cost)+cost[stair-1],minCost(stair-2,cost)+cost[stair-2]);
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] cost = new int[n];
    for(int i=0;i<n;i++){
        cost[i] = sc.nextInt();
    }
    int ans = minCost(n,cost);
    System.out.println(ans);
  }
}