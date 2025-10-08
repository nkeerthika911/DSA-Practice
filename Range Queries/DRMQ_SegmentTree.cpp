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
        tree[idx]=min(tree[idx*2],tree[idx*2+1]);
        return;
    }
    long findMin(vector<long> &tree, int idx, int left, int right, int ql, int qr){
        if(ql>right || qr<left){
            return LONG_MAX;
        }
        if(left>=ql && right<=qr){
            return tree[idx];
        }
        int mid = (left+right)/2;
        return min(findMin(tree, idx*2, left, mid, ql, qr),
        findMin(tree, idx*2+1, mid+1, right, ql, qr));
    }


    int main() {
        int n,q;
        cin>>n>>q;
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
                ans = findMin(tree,1,len,len*2-1,ql+len,qr+len);
                cout<<ans<<endl;
            }
        }
        return 0;
    }