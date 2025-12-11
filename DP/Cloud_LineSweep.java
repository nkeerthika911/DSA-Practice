// https://atcoder.jp/contests/abc434/tasks/abc434_d

import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[2001][2001];
		int[][] q = new int[n][4];
		for(int i=0;i<n;i++){
			q[i][0] = sc.nextInt();
			q[i][1] = sc.nextInt();
			q[i][2] = sc.nextInt();
			q[i][3] = sc.nextInt();
			q[i][0]--;
			q[i][2]--;
			grid[q[i][0]][q[i][2]]++;
			grid[q[i][0]][q[i][3]]--;
			grid[q[i][1]][q[i][2]]--;
			grid[q[i][1]][q[i][3]]++;
		}
		int count = 0;
		int prefSum = 0;
		//row wise updation
		for(int i=0;i<=2000;i++){
			for(int j=0;j<=2000;j++){
				prefSum+=grid[i][j];
				grid[i][j]=prefSum;
			}
		}
		// col wise updation
		prefSum = 0;
		for(int j=0;j<=2000;j++){
			for(int i=0;i<=2000;i++){
				prefSum+=grid[i][j];
				grid[i][j]=prefSum;
			}
		}
		for(int i=0;i<=2000;i++){
			for(int j=0;j<=2000;j++){
				if(grid[i][j]!=0) count++;
				// System.out.print(grid[i][j]+" ");
			}
			// System.out.println();
		}
		// System.out.println("Count: "+count);
		int[][] dp = new int[2001][2001];
		for(int i=1;i<=2000;i++){
			for(int j=1;j<=2000;j++){
				// (since ul is added twice, subtract it once)
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
				// (if the curr grid is 1, add that too)
				if(grid[i-1][j-1]==1) dp[i][j]++;
			}
		}
		// System.out.println();
		
		// for(int i=0;i<7;i++){
			// for(int j=0;j<7;j++){
				// System.out.print(dp[i][j]+" ");
			// }
			// System.out.println();
		// }
		// System.out.println();
		int TOTAL = 4000000;
		int u,d,l,r;
		for(int[] k:q){
			u=k[0];
			d=k[1];
			l=k[2];
			r=k[3];
			System.out.println(TOTAL-(count-(dp[d][r]-dp[d][l]-dp[u][r]+dp[u][l])));
		}
	}
}