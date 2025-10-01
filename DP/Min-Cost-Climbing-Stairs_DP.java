import java.util.*;

public class MyClass {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] cost = new int[n];
    for(int i=0;i<n;i++){
        cost[i] = sc.nextInt();
    }
    int[] minCost = new int[n+1];
    minCost[0]=0;
    minCost[1]=0;
    for(int i=2;i<=n;i++){
        minCost[i]=Math.min(minCost[i-1]+cost[i-1],minCost[i-2]+cost[i-2]);
    }
    System.out.println(minCost[n]);
  }
}