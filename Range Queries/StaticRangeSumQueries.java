import java.util.*;

class StaticRangeSumQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        long[] prefSum = new long[n+1];
        prefSum[0]=0;
        for(int i=0;i<n;i++){
            prefSum[i+1]=prefSum[i]+arr[i];
        }
        while(q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(prefSum[b]-prefSum[a-1]);
        }
    }
}