// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int k;
    cin>>k;
    deque<int> dq;
    for(int i=0;i<n;i++){
        if(dq.size()!=0 && dq.front()<=i-k){
            dq.pop_front();
        }
        while(dq.size()!=0 && arr[dq.back()]<=arr[i]){
            dq.pop_back();
        }
        dq.push_back(i);
        if(i>=2) cout<<dq.front()<<endl;
    }
    return 0;
    
}