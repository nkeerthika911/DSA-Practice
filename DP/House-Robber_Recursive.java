import java.util.*;

public class MyClass {
  
  public static int rob(int pos,int[]money){
      if(pos==0) return money[0];
      else if(pos==1) return Math.max(money[1],money[0]);
      return Math.max(rob(pos-1,money),money[pos]+rob(pos-2,money));
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] money = new int[n];
    for(int i=0;i<n;i++){
        money[i] = sc.nextInt();
    }
    int ans = rob(n-1,money);
    System.out.println(ans);
  }
}