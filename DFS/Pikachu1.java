import java.util.*;

public class Pikachu{
	private static int dfs(char[][] grid,int x,int y, String move, int[][] dir, int dirIdx, int[][] turn, int idx, int R , int C,boolean[][] visited){
        if(idx==move.length()){
            if(x>-1 && x<R && y>-1 && y<C && !visited[x][y]){
                visited[x][y]=true;
                return 1;
            }
            else return 0;
        }
        int nx=x,ny=y;
        if(move.charAt(idx)=='S'){
        	nx=x+dir[dirIdx][0];
            ny=y+dir[dirIdx][1];
        }
        else if(move.charAt(idx)=='L'){
            dirIdx=turn[dirIdx][0];
        }
        else{
           	dirIdx=turn[dirIdx][1];
        }
        if(nx<0 || nx>=R || ny<0 || ny>=C){
            int res = dfs(grid,nx,ny,move,dir,dirIdx,turn,idx+1,R,C,visited);
            if(res==1) return 1;
        }
        else if(grid[nx][ny]=='#'){
        	int res = dfs(grid,x,y,move,dir,dirIdx,turn,idx+1,R,C,visited);
            if(res==1) return 1;
        }
        else{
            int res = dfs(grid,nx,ny,move,dir,dirIdx,turn,idx+1,R,C,visited);
            if(res==1) return 1;
        }
        return 0;
    }
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        String line;
        char[][] grid = new char[R][C];
        for(int i=0;i<R;i++){
        	line=sc.next();
        	for(int j=0;j<C;j++){
            	grid[i][j]=line.charAt(j);
            }
        }
        int count = 0;
        String movements = sc.next();
        int[][] turn = {{2,3},{3,2},{1,0},{0,1}};
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean visited[][] = new boolean[R][C];
        for(int i=0;i<R;i++){
        	for(int j=0;j<C;j++){
            	if(grid[i][j]=='.'){
                	for(int k=0;k<4;k++){
                		count+= dfs(grid,i,j,movements,dir,k,turn,0,R,C,visited);
                    }
                }
            }
        }
        System.out.println(count);
    }
}