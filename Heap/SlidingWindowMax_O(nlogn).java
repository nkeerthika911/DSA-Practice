// Enter the no. of scores: 10
// Enter the scores: 34 56 34 22 45 67 23 11 88 2
// Enter no. of queries: 4
// Enter the queries: 3 5 1 3
// For window size: 3 Weakest Peak is: 45
// For window size: 5 Weakest Peak is: 56
// For window size: 1 Weakest Peak is: 2
// For window size: 3 Weakest Peak is: 45

import java.util.*;
import java.lang.*;

class Main {
    //Helper fns
    public static void insert(TreeMap<Integer,Integer> maxHeap, int[] scores, int idx){
        int count=maxHeap.getOrDefault(scores[idx],0);
        maxHeap.put(scores[idx],count+1);
    }
    public static void remove(TreeMap<Integer,Integer> maxHeap, int[] scores, int idx){
        int count=maxHeap.get(scores[idx]);
        if(count==1){
            maxHeap.remove(scores[idx]);
        }
        else{
            maxHeap.put(scores[idx],count-1);
        }
    }
    //Main fn
    public static void main(String[] args) {
        //Inputs
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the no. of scores: ");
        int n=sc.nextInt();
        int[] scores = new int[n];
        System.out.print("Enter the scores: ");
        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        System.out.print("Enter no. of queries: ");
        int q = sc.nextInt();
        int[] queries = new int[q];
        System.out.print("Enter the queries: ");
        for(int i=0;i<q;i++){
            queries[i]=sc.nextInt();
        }
        //Solution
        int window_size;
        for(int i=0;i<q;i++){
            int windowSize=queries[i];
            TreeMap<Integer,Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
            int minVal=Integer.MAX_VALUE;
            for(int j=0;j<windowSize;j++){
                insert(maxHeap,scores,j);
            }
            minVal=Math.min(minVal,maxHeap.firstKey());

            for(int j=windowSize;j<n;j++){
                insert(maxHeap,scores,j);
                remove(maxHeap,scores,j-windowSize);
                minVal=Math.min(minVal,maxHeap.firstKey());
            }
            System.out.println("For window size: "+windowSize+" Weakest Peak is: "+minVal);
        }
    }

}