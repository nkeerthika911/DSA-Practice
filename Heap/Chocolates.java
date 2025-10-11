import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total=0;
        int a;
        for(int i=0;i<n;i++){
            a=sc.nextInt();
            total+=a;
            pq.add(a);
        }
        int d = sc.nextInt();
        int curr;
        for(int i=0;i<d;i++){
            curr=pq.poll();
            if(curr/2!=0){
                pq.add(curr/2);
            }
            total-=(curr-(curr/2));
            if(pq.isEmpty()) break;
        }
        System.out.println(total);
    }
}