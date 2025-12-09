// https://atcoder.jp/contests/abc435/tasks/abc435_f

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N+1];
        int pos[]=new int[N+1];
        int lMax[]=new int[N+1];
        int rMax[]=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
            pos[arr[i]]=i;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=N;i++){
            while(!st.isEmpty() && st.peek()<arr[i]) st.pop();
            if(st.empty()) lMax[i]=arr[i];
            else lMax[i]=st.peek();
            st.push(arr[i]);
        }
        st.clear();
        for(int i=N;i>=1;i--){
            while(!st.isEmpty() && st.peek()<arr[i]) st.pop();
            if(st.empty()) rMax[i]=arr[i];
            else rMax[i]=st.peek();
            st.push(arr[i]);
        }
        long dist[]=new long[N+1];
        for(int i=N;i>0;i--){
            int left=lMax[pos[i]];
            int right=rMax[pos[i]];
            int min=Math.min(left,right);
            if(i==min) i= (left<right)?right:left;
            dist[i]=Math.abs(pos[min]-pos[i])+dist[min];
        }
        long res=0;
        for(long num:dist) res=Math.max(res,num);
        System.out.println(res);
    }
}