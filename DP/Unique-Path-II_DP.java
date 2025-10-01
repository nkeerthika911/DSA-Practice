import java.util.*;

class Main{
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                obstacleGrid[i][j] = sc.nextInt();
            }
        }
        int[][] grid = new int[m][n];
        int flag=0;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                flag=1;
            }
            if(flag==1) grid[i][0]=0;
            else grid[i][0]=1;
        }
        flag=0;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                flag=1;
            }
            if(flag==1) grid[0][i]=0;
            else grid[0][i]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) grid[i][j]=0;
                else grid[i][j]=grid[i-1][j]+grid[i][j-1];
            }
        }
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}