// https://codeforces.com/contest/2153/problem/C

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            HashMap<Integer,Integer> hm = new HashMap<>();
            int n = sc.nextInt();
            int a;
            for(int i=0;i<n;i++){
                a = sc.nextInt();
                hm.put(a,hm.getOrDefault(a,0)+1);
            }
            ArrayList<Integer> odds = new ArrayList<>();
            long perimeter = 0;
            int sticks = 0;
            for(Integer key:hm.keySet()){
                if(hm.get(key)%2==1){
                    odds.add(key);
                    perimeter+=(long)(hm.get(key)-1)*key;
                    sticks+=(hm.get(key)-1);
                }
                else{
                    perimeter+=(long)hm.get(key)*key;
                    sticks+=hm.get(key);
                }
            }
            if(perimeter==0){
                System.out.println(0);
                continue;
            }
            boolean takenTwos = false;
            Collections.sort(odds,Collections.reverseOrder());
            if(odds.size()>1){
                for(int i=0;i<odds.size()-1;i++){
                    if((long)(perimeter+odds.get(i+1))>odds.get(i)){
                        perimeter+=(long)(odds.get(i)+odds.get(i+1));
                        sticks+=2;
                        takenTwos=true;
                        break;
                    }
                }
            }
            if(takenTwos){
                System.out.println(perimeter);
                continue;
            }
            else{
                for(int i=0;i<odds.size();i++){
                    if(perimeter>odds.get(i)){
                        perimeter+=(long)(odds.get(i));
                        sticks++;
                        break;
                    }
                }
                if(sticks>=3) System.out.println(perimeter);
                else System.out.println(0);
            }
        }
    }
}
