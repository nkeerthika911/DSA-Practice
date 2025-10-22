// Question: https://codeforces.com/problemset/problem/2143/C
// Logic: https://youtu.be/jDZITHpSq1o
// Solution: https://www.youtube.com/watch?v=WOJpUI_Gxj4

#include<bits/stdc++.h>
using namespace std;

void dfs(int i,vector<vector<int>>&adj, vector<bool>&vis, stack<int>&stk){
    vis[i]=true;
    for(int neigh:adj[i]){
        if(!vis[neigh]){
            dfs(neigh,adj,vis,stk);
        }
    }
    stk.push(i);
}

int main(){
    int T;
    cin>>T;
    while(T--){
        int n;cin>>n;
        vector<vector<int>>adj(n+1);
        int u,v,x,y;
        for(int i=0;i<n-1;i++){
            cin>>u>>v>>x>>y;
            if(x>=y){
                adj[u].push_back(v);
            }else{
                adj[v].push_back(u);
            }
        }
        vector<bool>vis(n+1,false);
        stack<int>stk;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(i,adj,vis,stk);
            }
        }
        vector<int>ans(n+1);
        for(int i=n;i>0;i--){
            ans[stk.top()]=i;
            stk.pop();
        }
        for(int i=1;i<=n;i++){
            cout<<ans[i]<<" ";
        }
        cout<<"\n";
    }
    return 0;
}
