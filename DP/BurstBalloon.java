// https://leetcode.com/problems/burst-balloons/description/

// https://youtu.be/IFNibRVgFBo?si=pjL3-QpzctVtD5L-
// Refer to this video in case of doubts

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                for(int k=i;k<=j;k++){
                    int left = 1;
                    int right = 1;
                    if(i!=0){
                        left=nums[i-1];
                    }
                    if(j!=n-1){
                        right=nums[j+1];
                    }
                    int lSum=0;
                    int rSum=0;
                    if(k!=i) lSum=dp[i][k-1];
                    if(k!=j) rSum=dp[k+1][j];
                    dp[i][j] = Math.max(dp[i][j],left*right*nums[k]+lSum+rSum);
                }
            }
        }
        return dp[0][n-1];
    }
}