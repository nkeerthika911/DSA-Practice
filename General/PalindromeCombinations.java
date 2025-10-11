import java.util.*;

class Main {
    public static long getFreq(String s){
        int val=0;
        for(int i=0;i<s.length();i++){
            val=val^(1<<(s.charAt(i)-'a'));
        }
        return val;
    }
    public static int[] compute(String[] s, HashMap<Long,Integer> odd, HashMap<Long,Integer> np){
        long freq;
        int oddC=0,evenC=0;
        for(int i=0;i<s.length;i++){
            freq=getFreq(s[i]);
            if(freq==0){
                evenC++;
            }
            else if((freq&(freq-1))==0){
                oddC++;
                odd.put(freq,odd.getOrDefault(freq,0)+1);
            }
            else{
                np.put(freq,np.getOrDefault(freq,0)+1);
            }
        }
        return new int[]{evenC,oddC};
    }
    public static void main(String[] args) {
        String[] s1 = {"c","aaabbb", "xyza", "abcdef"};
        String[] s2 = {"ab", "xyz", "cbead"};
        Integer evenCount1=0,evenCount2=0;
        Integer oddCount1=0,oddCount2=0;
        HashMap<Long,Integer> odd1 = new HashMap<>();
        HashMap<Long,Integer> odd2 = new HashMap<>();
        HashMap<Long,Integer> np1 = new HashMap<>();
        HashMap<Long,Integer> np2 = new HashMap<>();
        int arr1[] = compute(s1,odd1,np1);
        int arr2[] = compute(s2,odd2,np2);
        evenCount1=arr1[0];
        oddCount1=arr1[1];
        evenCount2=arr2[0];
        oddCount2=arr2[1];
        int total=0;
        System.out.println("e1: "+evenCount1+" o1: "+oddCount1+" oddMap: "+odd1+" npMap: "+np1);
        System.out.println("e2: "+evenCount2+" o2: "+oddCount2+" oddMap: "+odd2+" npMap: "+np2);
        total+=(evenCount1*evenCount2);
        total+=(evenCount1*oddCount2);
        total+=(evenCount2*oddCount1);
        for(Long key:odd1.keySet()){
            if(odd2.containsKey(key)){
                total+=(odd1.get(key)*odd2.get(key));
            }
        }
        for(Long key:np1.keySet()){
            if(np2.containsKey(key)){
                total+=(np1.get(key)*np2.get(key));
            }
        }
        System.out.println(total);
    }
}