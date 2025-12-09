#include <bits/stdc++.h>
using namespace std;

int findMax(vector<int> &tree, int idx, int left, int right, int ql, int qr){
    if(ql>right || qr<left){
        return INT_MIN;
    }
    if(left>=ql && right<=qr){
        return tree[idx];
    }
    int mid = (left+right)/2;
    return max(findMax(tree, idx*2, left, mid, ql, qr),
    findMax(tree, idx*2+1, mid+1, right, ql, qr));
}

int main() {
    int n;
    cin>>n;
    int lg = 0;
    while((1<<lg)<n){
        lg++;
    }
    int len = 1<<lg;
    vector<int> tree(len*2,INT_MIN);
    int start_pos;
    unordered_map<int,int> hm;
    for(int i=len;i<len+n;i++){
        cin>>tree[i];
        if(tree[i]==n) start_pos=i;
        hm[tree[i]]=i;
    }
    for(int i=len-1;i>0;i--){
        tree[i]=max(tree[2*i],tree[2*i+1]);
    }
    int count = 0;
    int max_value;
    int vl=len,vr=len+n-1;
    while(start_pos>=vl && start_pos<=vr){
        cout<<"Start pos: "<<start_pos-len<<" vl: "<<vl-len<<" vr: "<<vr-len<<" count: "<<count<<endl;
        if(start_pos==len){
            max_value = findMax(tree,1,len,len*2-1,start_pos+1,vr);
            vl=start_pos+1;
        }
        else if(start_pos==len+n-1){
            max_value = findMax(tree,1,len,len*2-1,start_pos-1,vl);
            vr=start_pos-1;
        }
        else{
            if(abs(start_pos-vl)>=abs(start_pos-vr)){
                max_value = findMax(tree,1,len,len*2-1,start_pos-1,vl);
                vr=start_pos-1;
            }
            else{
                max_value = findMax(tree,1,len,len*2-1,start_pos+1,vr);
                vl=start_pos+1;
            }
        }
        count+=abs(start_pos-hm[max_value]);
        if(vl==vr) break;
        start_pos=hm[max_value];
    }
    cout<<count;
    return 0;
}