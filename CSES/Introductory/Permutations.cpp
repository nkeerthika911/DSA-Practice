#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    if(n>1 && n<4){
        cout<<"NO SOLUTION";
        return 0;
    }
    int first = 1;
    int half = n/2 + 1;
    int halfcpy = half;
    while(first!=halfcpy && half!=n+1){
       cout<<(half++)<<" "<<(first++)<<" ";
    }
    if(half==n) cout<<n;
    return 0;
}