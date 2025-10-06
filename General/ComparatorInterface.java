import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> li = new ArrayList<>();
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]>b[0]){
                    return 1; //Swap
                }
                else if(a[0]==b[0]){
                    if(a[1]>b[1]) return 1;
                    else return 0; // Equal
                }
                else{
                    return -1; // No swap
                }
            }
        };
        int a,b;
        for(int i=0;i<n;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            li.add(new int[]{a,b});
        }
        Collections.sort(li,comp);
        for(int i=0;i<n;i++){
            System.out.println(li.get(i)[0]+" "+li.get(i)[1]);
        }
    }
}
