#include <bits/stdc++.h>
using namespace std;

int dfs(int node, int par, vector<vector<int>> &adj, vector<int> &h){
    // cout<<"IN DFS"<<endl;
    int ans = 0;
    priority_queue<int> pq;
    for(int neigh: adj[node]){
        if(neigh==par) continue;
        pq.push(h[neigh]+1);
    }
    for(int i=0;i<2;i++){
        if(pq.size()!=0){
            ans+=pq.top();
            pq.pop();
        }
        else break;
    }
    for(int neigh: adj[node]){
        if(neigh!=par){
            ans=max(ans,dfs(neigh,node,adj,h));
        }
    }
    return ans;
}

int findHeight(int node, int par, vector<vector<int>> &adj, vector<int> &h){
    for(int neigh: adj[node]){
        if(neigh==par) continue;
        h[node]=max(findHeight(neigh,node,adj,h)+1,h[node]);
    }
    return h[node];
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
    vector<int> h(n+1,0);
    findHeight(1,-1,adj,h);
    cout<<dfs(1,-1,adj,h);
}