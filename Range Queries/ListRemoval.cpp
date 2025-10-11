// SEGMENT TREE

#include <bits/stdc++.h>
using namespace std;

long del(vector<long> &tree, int idx, int left, int right, int pos, int len){
    if()
}


int main() {
    int n,q;
    cin>>n>>q;
    int lg = 0;
    while((1<<lg)<n){
        lg++;
    }
    int len = 1<<lg;
    vector<long> tree(len*2,0);
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    for(int i=len;i<len+n;i++){
        tree[i]=1;
    }
    for(int i=len-1;i>0;i--){
        tree[i]=tree[2*i]+tree[2*i+1];
    }
    int pos;
    long ans;
    while(q-->0){
        cin>>pos;
        ans = del(tree,1,len,len*2-1,pos,len);
        cout<<ans<<endl;
    }
    return 0;
}