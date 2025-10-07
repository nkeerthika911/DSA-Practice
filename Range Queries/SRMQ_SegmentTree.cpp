// Segment Tree

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    int lg = 0;
    while((1<<lg)<n){
        lg++;
    }
    int len = 1<<lg;
    vector<long> tree(len*2,LONG_MAX);
    for(int i=len;i<len+n;i++){
        cin>>tree[i];
    }
    for(int i=len-1;i>0;i--){
        tree[i]=min(tree[2*i],tree[2*i+1]);
    }
    for(int i=0;i<len*2;cout<<i<<" "<<tree[i++]<<endl);
    return 0;
}