import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int Q = sc.nextInt();
    Stack<Character> stk = new Stack<>();
    int qtype;
    char c;
    boolean isValid=true;
    int openCount=0,closedCount=0;
    while(Q-->0){
      qtype=sc.nextInt();
      if(qtype==1){
        c = sc.next().charAt(0);
        if(c=='('){
          stk.push(c);
          System.out.println("No");
          isValid=false;
          openCount++;
        }
        else{
          if(stk.size()!=0 && stk.peek()=='(' && (openCount-1==closedCount)){
            stk.push(')');
            System.out.println("Yes");
            isValid=true;
          }
          else{
            stk.push(c);
            System.out.println("No");
            isValid=false;
          }
          closedCount++;
        }
      }
      else{
        if(stk.peek()==')'){
            closedCount--;
        }
        else{
            openCount--;
        }
        stk.pop();
        if(stk.size()==0){
            System.out.println("Yes");
        }
        else if(stk.peek()==')' && isValid && (openCount==closedCount)){
          System.out.println("Yes");
        }
        else{
          System.out.println("No");
        }
      }
    }
  }
}

// ( - No
//   - Yes
// ( - No
// () - Yes
// ( - No 2
// (( - No 1 (
// (()

