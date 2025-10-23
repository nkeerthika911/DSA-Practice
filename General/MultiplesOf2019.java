import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n=s.length()-1;
        int curr=0;
        int rem=0;
        int tenp=1;
        int val=0;
        int ans=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        while(n>-1){
            curr=(int)(s.charAt(n)-'0');
            rem=(rem+(curr*tenp))%2019;
            if(hm.containsKey(rem)){
                ans+=hm.get(rem);
            }
            hm.put(rem,hm.getOrDefault(rem,0)+1);
            tenp*=10;
            tenp%=2019;
            n--;
        }
        System.out.println(ans);
    }
}