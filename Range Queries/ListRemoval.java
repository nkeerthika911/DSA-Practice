import java.io.*;
import java.util.*;
public class ListRemoval {
    static int find(int[] t, int node,int start,int end, int k) {
        if(start==end)
        {
            t[node]-=1;
            return start;
        }
        if(t[node]<k)
        {
            return 0;
        }
        int mid = (start + end) / 2;
        int left = t[2*node];
        int idx;
        if(k<=left)
        {
            idx=find(t, 2 * node, start, mid, k);
        }
        else{
 
        
        idx = find(t, 2 * node + 1, mid + 1, end, k-left);
        }
        t[node] = t[node*2]+t[node*2+1];
        return idx;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int log = 0;
        while ((1 << log) < n) log++;
        int size = 1 << log;
        int[] t = new int[size << 1];
        int arr[]=new int[n];
        for (int i = 0; i < n; i++)
        {
            t[size + i] = 1;
            arr[i]=Integer.parseInt(st.nextToken());
        }
 
        for (int i = size - 1; i > 0; i--)
            t[i] = t[2 * i] + t[2 * i + 1];
    
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            
            int l = Integer.parseInt(st.nextToken());
            int ind = find(t, 1, 0, size - 1, l);
            sb.append(arr[ind]).append(" ");
        }
 
        System.out.print(sb);
 }   
}