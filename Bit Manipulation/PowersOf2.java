// given a number n, adding what powers of 2 gives n
// 10 = 2+8
// 7 = 1+2+4

import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = 0;
		while(n!=0){
			if((n&1)!=0) System.out.println(Math.pow(2,p));
			p++;
			n=n>>1;
		}
	}
}