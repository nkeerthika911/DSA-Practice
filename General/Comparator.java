import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(sc.next().charAt(0),i+1);
        }
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a, String b){
                int i=0;
                while(i<Math.min(a.length(),b.length()) && a.charAt(i)==b.charAt(i)){
                    i++;
                }
                if(i==Math.min(a.length(),b.length())){
                    if(a.length()==b.length()) return 0;
                    else if(a.length()>b.length()){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
                else{
                    if(hm.get(a.charAt(i))>hm.get(b.charAt(i))){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        };
        List<String> li = new ArrayList<>();
        String a;
        int k=sc.nextInt();
        for(int i=0;i<k;i++){
            a = sc.next();
            li.add(a);
        }
        Collections.sort(li,comp);
        for(int i=0;i<k;i++){
            System.out.println(li.get(i));
        }
    }
}
