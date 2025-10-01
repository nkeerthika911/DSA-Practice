import java.util.*;

public class MyClass {
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] money = new int[n];
    for(int i=0;i<n;i++){
        money[i] = sc.nextInt();
    }
    int[] maxRob = new int[n];
    maxRob[0]=money[0];
    maxRob[1]=Math.max(money[0],money[1]);
    for(int i=2;i<n;i++){
        maxRob[i]=Math.max(maxRob[i-1],maxRob[i-2]+money[i]);
    }
    System.out.println(maxRob[n-1]);
  }
}