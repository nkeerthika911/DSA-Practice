package DSA;

import java.util.*;
public class Program1 {
    static int min=Integer.MAX_VALUE;
    private static int count(int[][] board, boolean visited[][]){
        int count=0;
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(visited[row][col] && board[row][col]%10==2){
                    count++;
                    //left
                    int c=col;
                    while(c>-1 && (board[row][c]==12 || board[row][c]==4)){
                        visited[row][c]=false;
                        c--;
                    }
                    //right
                    c=col;
                    while(c<board[0].length && (board[row][c]==12 || board[row][c]==4)){
                        visited[row][c]=false;
                        c++;
                    }
                }
                
            }
        }
        return count;
    }
    private static boolean dfs(int[][] board, int row, int col, boolean visited[][]){
        int[] rowIn=new int[]{0,1,0,-1};
        int[] colIn=new int[]{1,0,-1,0};
//        System.out.println("CHECK: "+row+" "+col);
        visited[row][col]=true;
        if(board[row][col]%10==3){
            printVisited(visited);
            int count=count(board,visited);
//            System.out.println("COUNT: "+count);
            if(count<min){
                min=count;
            }
            return true;
        }
        for(int index=0;index<rowIn.length;index++){
            int newRow=row+rowIn[index];
            int newCol=col+colIn[index];
            if(newRow>-1 && newCol>-1 && newRow<board.length && newCol<board[0].length){
                if(!visited[newRow][newCol] && (board[newRow][newCol]%10==2 || board[newRow][newCol]==4 || board[newRow][newCol]%10==3)){
                    int temp=board[newRow][newCol];
                    dfs(board,newRow,newCol, visited);
                    board[newRow][newCol]=temp;
                }
            }
        }
        return false;
    }
    private static void print(int[][] arr){
        System.out.println("--------ARRAY--------");
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
    private static void printVisualise(int[][] arr){
        System.out.println("--------ARRAY--------");
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if(col==0){
                    System.out.print("|");
                }
                if(arr[row][col]%10==1){
                    System.out.print("R");
                }
                else if(arr[row][col]%10==2 || arr[row][col]%10==4){
                    System.out.print("G");
                }
                else if(arr[row][col]%10==3){
                    System.out.print("D");
                }
                else if(arr[row][col]%10==0){
                    System.out.print("S");
                }
                if(col+1<arr.length){
                    if(arr[row][col]==12){
                        if(arr[row][col+1]!=4)
                            System.out.print("|");
                        else
                            System.out.print(" ");
                    }
                    else if(arr[row][col]>10 && (arr[row][col]!=arr[row][col+1])){
                        System.out.print("|");
                    }
                    else if(arr[row][col]<10){
                        System.out.print("|");
                    }
                }
                else{
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
    private static void printVisited(boolean[][] arr){
        System.out.println("--------FOUND PATH--------");
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if(arr[row][col]){
                    System.out.print("-| ");
                }
                else{
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
    private static void assign(int[][] arr, int i, int ptr, char c, int flag){
        //flag==1 continue flag==0 not continuous
        //red = 1
        //green = 2,         //flag==1 = 4;
        //source = 0,
        // destination = 3
        int value=-1;
        if(c=='R'){
            value=1;
        }
        else if(c=='G'){
            value=2;
        }
        else if(c=='S'){
            value=0;
        }
        else if(c=='D'){
            value=3;
        }

        if(value==2 && flag==2){
            arr[i][ptr]=4;
            return;
        }
        arr[i][ptr]=flag*10+value;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            String temp=sc.nextLine();
            int ptr=0;
            int index=0;
            while(ptr<temp.length()){
                int count=0;
                while(ptr<temp.length() && temp.charAt(ptr)>='0' && temp.charAt(ptr)<='9'){
                    count=count*10+(int)(temp.charAt(ptr)-'0');
                    ptr++;
                }
                char c=temp.charAt(ptr);
                if(count>1){
                    for(int k=0;k<count;k++,index++){
                        if(k!=0 && k!=count-1)
                            assign(arr,i,index,c,2);
                        else
                            assign(arr,i,index,c,1);
                    }
                }
                else{
                    assign(arr,i,index,c,0);
                    index++;
                }
                ptr++;
            }
//            for(int j=0;j<temp.length();j+=2){
//                System.out.println("j"+j+" "+(j+1));
//                int count=temp.charAt(j)-'0';
//                char c=temp.charAt(j+1);
//                if(count>1){
//                    for(int k=0;k<count;k++,ptr++){
//                        assign(arr,i,ptr,c,1);
//                    }
//                }
//                else{
//                    assign(arr,i,ptr,c,0);
//                    ptr++;
//                }
//            }
            
        }
        print(arr);
        printVisualise(arr);
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if(arr[row][col]%10==0){
                    boolean[][]  visited=new boolean[arr.length][arr[0].length];
                    System.out.println("DFS");
                    dfs(arr,row,col,visited);
                }
            }
        }
        System.out.println(min);
    }
}
