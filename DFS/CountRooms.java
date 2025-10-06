import java.util.*;
class CountRooms {
private static void dfs(char[][] grid, int x, int y, int R, int C) {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{x, y});
    grid[x][y] = '#';

    while (!stack.isEmpty()) {
        int[] curr = stack.pop();
        for (int[] d : dir) {
            int nx = curr[0] + d[0];
            int ny = curr[1] + d[1];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && grid[nx][ny] == '.') {
                grid[nx][ny] = '#';
                stack.push(new int[]{nx, ny});
            }
        }
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        String line;
        for(int i=0;i<R;i++){
            line = sc.next();
            for(int j=0;j<C;j++){
                grid[i][j]=line.charAt(j);
            }
        }
        int count=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]=='.'){
                    count++;
                    dfs(grid,i,j,R,C);
                }
            }
        }
        System.out.println(count);
    }
}