// SEGMENT TREE

#include <bits/stdc++.h>
using namespace std;

void update(vector<long> &tree, int idx, int left, int right, int ql, int qr, int val){
    if(left>qr || right<ql){
        return;
    }
    if(left>=ql && right<=qr){
        tree[idx]=val;
        return;
    }
    int mid = (left+right)/2;
    update(tree,idx*2,left,mid,ql,qr,val);
    update(tree,idx*2+1,mid+1,right,ql,qr,val);
    tree[idx]=tree[idx*2]+tree[idx*2+1];
    return;
}

long findSum(vector<long> &tree, int idx, int left, int right, int ql, int qr){
    if(ql>right || qr<left){
        return 0;
    }
    if(left>=ql && right<=qr){
        return tree[idx];
    }
    int mid = (left+right)/2;
    return findSum(tree, idx*2, left, mid, ql, qr)+findSum(tree, idx*2+1, mid+1, right, ql, qr);
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
    for(int i=len;i<len+n;i++){
        cin>>tree[i];
    }
    for(int i=len-1;i>0;i--){
        tree[i]=tree[2*i]+tree[2*i+1];
    }
    int ql,qr,k,u,qt;
    long ans;
    while(q-->0){
        cin>>qt;
        if(qt==1){
            cin>>k>>u;
            k--;
            update(tree,1,len,len*2-1,len+k,len+k,u);
        }
        else{
            cin>>ql>>qr;
            ql--;
            qr--;
            ans = findSum(tree,1,len,len*2-1,ql+len,qr+len);
            cout<<ans<<endl;
        }
    }
    return 0;
}