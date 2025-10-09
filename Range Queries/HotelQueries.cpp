    // SEGMENT TREE

    #include <bits/stdc++.h>
    using namespace std;

    int findMax(vector<long> &tree, int idx, int left, int right, int req, int n){
        if(tree[idx]<req){
            return -1;
        }
        if(left==right){
            tree[idx]-=req;
            return (left-n)+1;
        }
        int mid = (left+right)/2;
        int leftFind,rightFind,ans;
        if(tree[idx*2]>=req){
            ans = findMax(tree,idx*2,left,mid,req,n);
        }
        else{
            ans = findMax(tree,idx*2+1,mid+1,right,req,n);
        }
        tree[idx]=max(tree[idx*2],tree[idx*2+1]);
        return ans;
    }


    int main() {
        int n,q;
        cin>>n>>q;
        int lg = 0;
        while((1<<lg)<n){
            lg++;
        }
        int len = 1<<lg;
        vector<long> tree(len*2,LONG_MIN);
        for(int i=len;i<len+n;i++){
            cin>>tree[i];
        }
        for(int i=len-1;i>0;i--){
            tree[i]=max(tree[2*i],tree[2*i+1]);
        }
        long ans,req;
        while(q-->0){
            cin>>req;
            ans = findMax(tree,1,len,len*2-1,req,len);
            ans=(ans==-1)?0:ans;
            cout<<ans<<endl;
        }
        return 0;
    }