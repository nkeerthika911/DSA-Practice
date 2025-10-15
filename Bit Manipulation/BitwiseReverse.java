// Refer
// https://youtu.be/9lg3FUXDn4E 
// https://codeforces.com/contest/2153/problem/B

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int flag=0;
            while(a!=0 || b!=0 || c!=0){
                if((a%2 + b%2 + c%2)==2){
                    System.out.println("NO");
                    flag=1;
                    break;
                }
                a=a>>1;
                b=b>>1;
                c=c>>1;
            }
            if(flag==0) System.out.println("YES");
        }
    }
}
