import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=n-1;i>-1;i--){
            for(int j=i;j<n;j++){
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                    maxLen=Math.max(maxLen,dp[i]);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
    }
}