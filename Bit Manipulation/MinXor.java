// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "aaabcc";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),1+hm.getOrDefault(s.charAt(i),0));
        }
        char c;
        int max=100;
        int min=2;
        int count = 0;
        for(Integer val: hm.values()){
            if(val%2==1){
                count++;
            }
        }
        boolean isEven=false;
        if(count%2==0) isEven=true;
        int xor=0;
        for(int i=0;i<26;i++){
            c=(char)('a'+i);
            if(hm.containsKey(c)){
                if(hm.get(c)%2==0)
                {
                    System.out.println(c+" "+max--);
                }
                else{
                    if(count==1 && !isEven){
                        System.out.println(c+" "+1);
                        xor^=1;
                    }
                    else{
                        System.out.println(c+" "+min);
                        xor^=min++;
                        count--;
                    }
                }
            }
            else{
                System.out.println(c+" "+max--);
            }
        }
        
        System.out.println("XOR: "+xor);
    }
}