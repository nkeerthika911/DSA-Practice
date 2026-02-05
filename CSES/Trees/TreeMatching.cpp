#include <bits/stdc++.h>
using namespace std;

void dfs(int node, int parent, vector<vector<int>> &dp, vector<vector<int>> &adj){
    for(int neigh: adj[node]){
        if(neigh==parent) continue;
        dfs(neigh,node,dp,adj);
        dp[node][0]+=max(dp[neigh][0],dp[neigh][1]);
    }
    for(int neigh: adj[node]){
        if(neigh==parent) continue;
        dp[node][1]=max(dp[node][1],1+dp[node][0]-max(dp[neigh][0],dp[neigh][1])+dp[neigh][0]);
    }
}
int main(){
    int n;
    cin>>n;
    vector<vector<int>> adj(n+1);
    for(int i=1;i<n;i++){
        int u,v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<vector<int>> dp(n+1,vector<int>(2,0));
    dfs(1,0,dp,adj);
    cout<<max(dp[1][1],dp[1][0]);
}