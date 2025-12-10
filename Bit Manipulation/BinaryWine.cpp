// https://codeforces.com/contest/2165/problem/C

#include <bits/stdc++.h>
using namespace std;

int main(){
	int t;
	cin>>t;
	while(t-->0){
		int n,q;
		cin>>n>>q;
        // multiset is sorted set that allows duplicate values
		multiset<int> ms;
		int val;
		for(int i=0;i<n;i++){
			cin>>val;
			ms.insert(val);
		}
        // you at max will use 30 valuess for 30 bits in c, so remove other elements
		while(ms.size()>30) ms.erase(ms.begin());
		while(q-->0){
			int c;
			cin>>c;
			int coins = 0;
			int pow = 0;
			int maxVal = INT_MIN;
			int rem = 0;
            // copy of ms since each query is independent
			multiset<int> ms1(ms);
			for(int sh=29;sh>-1;sh--){
                // shifting goes like
                // if c is 110000000
                // sh = 8 -> 1&1 = 1
                // sh = 7 -> 11&1 = 1
                // sh = 6 -> 110&1 = 0
				if(((c>>sh)&1)!=0){
                    // end iterator is one place ahead so you subtract
					maxVal = *(--ms1.end());
					pow = (1<<sh);
                    // if max is greater, use that and put rem back in set
					if(maxVal>=pow){
						rem=maxVal-pow;
					}
                    // else just add the reqd coins
					else{
						coins+=(pow-maxVal);
                        rem=0;
					}
                    ms1.erase(--ms1.end());
                    ms1.insert(rem);
				}
			}
			cout<<coins<<endl;
		}
	}
}