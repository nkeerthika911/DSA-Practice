#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,q;
    cin>>n>>q;
    vector<long> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int lg=0;
    while((1<<lg)<=n){
        lg++;
    }
    vector<int> logArr(n);
    cout<<"LOG ARRAY"<<endl;
    for(int i=2;i<=n;i++){
        logArr[i]=logArr[i/2]+1;
        cout<<i<<" "<<logArr[i]<<endl;
    }
    vector<vector<long>> table(lg,vector<long>(n,LONG_MIN));
    for(int i=0;i<n;i++){
        table[0][i]=arr[i];
    }
    for(int i=1;i<lg;i++){
        for(int j=0;j<n;j++){
            if(j+(1<<i-1)<n){
                table[i][j]=min(table[i-1][j],table[i-1][j+(1<<(i-1))]);
            }
        }
    }
    cout<<"SPARSE TABLE"<<endl;
    for(int i=0;i<lg;i++){
        for(int j=0;j<n;j++){
            if(table[i][j]>=0) cout<<table[i][j]<<' ';
        }
        cout<<endl;
    }
    cout<<"ANS"<<endl;
    int L,R,range,k,rem,ans;
    while(q-->0){
        cin>>L>>R;
        L--;
        R--;
        range = R-L+1;
        k=logArr[range];
        rem=range-(1<<k);
        ans = min(table[k][L],table[k][L+rem]);
        cout<<ans<<endl;
    }
    
    
}