// SEGMENT TREE

#include <bits/stdc++.h>
using namespace std;

void update(vector<long> &tree, int idx, int left, int right, int ql, int qr, int val){
    if(left>qr || right<ql){
        return;
    }
    if(left>=ql && right<=qr){
        tree[idx]+=val;
        return;
    }
    int mid = (left+right)/2;
    update(tree,idx*2,left,mid,ql,qr,val);
    update(tree,idx*2+1,mid+1,right,ql,qr,val);
    return;
}

long find(vector<long> &tree, int idx, int left, int right, int ql, int qr){
    if(ql>right || qr<left){
        return 0;
    }
    if(left>=ql && right<=qr){
        return tree[idx];
    }
    int mid = (left+right)/2;
    return tree[idx]+find(tree, idx*2, left, mid, ql, qr)+find(tree, idx*2+1, mid+1, right, ql, qr);
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
    int idx,l,r,val,qt;
    long ans;
    while(q-->0){
        cin>>qt;
        if(qt==1){
            cin>>l>>r>>val;
            l--;
            r--;
            update(tree,1,len,len*2-1,len+l,len+r,val);
        }
        else{
            cin>>idx;
            idx--;
            ans = find(tree,1,len,len*2-1,idx+len,idx+len);
            cout<<ans<<endl;
        }
    }
    return 0;
}