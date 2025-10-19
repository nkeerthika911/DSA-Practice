// https://codeforces.com/problemset/problem/2160/C
// https://www.youtube.com/watch?v=wVeA-O8TJJ4

import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println("YES");
                continue;
            }
            while(n%2==0){
                n/=2;
            }
            int lg=0;
            while((1<<lg)<=n){
                lg++;
            }
            int l=0,r=lg-1;
            int flag=0;
            while(l<r){
                if((n&1)!=((n>>r)&1)){
                    System.out.println("NO");
                    flag=1;
                    break;
                }
                r-=2;
                n=n>>1;
            }
            if(l==r){
                if((n&1)==1){
                    System.out.println("NO");
                }
                else{
                    System.out.println("YES");
                }
            }
            else{
                if(flag==0) System.out.println("YES");
            }
        }
    }
}

// 1 1 0 1
// r     l

// 1 0 1 
// r   l

// 1 0 1







