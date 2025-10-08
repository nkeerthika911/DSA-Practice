import java.util.*;

class Node{
    int x;
    int y;
    int len;
    StringBuilder path;
    Node(int x,int y, int len, StringBuilder path){
        this.x=x;
        this.y=y;
        this.len=len;
        this.path=path;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int startX=0,startY=0,stopX=0,stopY=0;
        char[][] grid = new char[R][C];
        String line;
        for(int row=0;row<R;row++){
            line = sc.next();
            for(int col=0;col<C;col++){
                grid[row][col]=line.charAt(col);
                if(grid[row][col]=='A'){
                    startX=row;
                    startY=col;
                }
                if(grid[row][col]=='B'){
                    stopX=row;
                    stopY=col;
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0, new StringBuilder()));
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean visited[][] = new boolean[R][C];
        visited[startX][startY]=true;
        Node curr;
        int nx,ny;
        char d;
        while(!q.isEmpty()){
            curr=q.poll();
            for(int i=0;i<4;i++){
                nx=curr.x+dir[i][0];
                ny=curr.y+dir[i][1];
                if(nx>-1 && nx<R && ny>-1 && ny<C && grid[nx][ny]!='#' && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(i==0) d='R';
                    else if(i==1) d='D';
                    else if(i==2) d='U';
                    else d='L';
                    StringBuilder sb = new StringBuilder(curr.path);
                    sb.append(d);
                    if(grid[nx][ny]=='B'){
                        System.out.println("YES");
                        System.out.println(curr.len+1);
                        System.out.println(sb);
                        return;
                    }
                    q.add(new Node(nx,ny,curr.len+1,sb));
                }
            }
        }
        System.out.println("NO");
    }
}