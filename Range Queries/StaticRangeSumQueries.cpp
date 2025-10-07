#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,q;
    cin>>n>>q;
    vector<long> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    vector<long> prefSum(n);
    prefSum[0]=0;
    for(int i=0;i<n;i++){
        prefSum[i+1]=prefSum[i]+arr[i];
    }
    while(q-->0){
        int a,b;
        cin>>a>>b;
        cout<<prefSum[b]-prefSum[a-1]<<endl;
    }
}