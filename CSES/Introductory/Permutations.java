import java.util.*;

class Permutations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>1 && n<4){
            System.out.println("NO SOLUTION");
            return;
        }
        int first = 1;
        int half = n/2 + 1;
        int halfcpy = half;
        while(first!=halfcpy && half!=n+1){
            System.out.print((half++) +" "+(first++)+" ");
        }
        if(half==n) System.out.println(n);
    }
}
