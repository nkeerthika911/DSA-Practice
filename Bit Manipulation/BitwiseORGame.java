import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int[] arr = new int[n];
            int or=0;
            int sum=0;
            for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            or|=arr[i];
            }
            int[] dp = new int[or+1];
            Arrays.sort(arr);
            for(int i=0;i<or+1;i++){
                dp[i]=Integer.MAX_VALUE;
            }
            dp[0]=0;
            for(int i=1;i<=or;i++){
            for(int j=0;j<n;j++){
                if(dp[i]!=Integer.MAX_VALUE){
                if(dp[i|arr[j]]>dp[i]+1){
                    dp[i|arr[j]]=dp[i]+1;
                }
                }
            }
            }
            if((n-dp[or])%2==0){
            System.out.println("Alice");
            }
            else{
            System.out.println("Bob");
            }
        }
    }
}