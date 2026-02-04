// Problem: Subordinates
// Contest: CSES - CSES Problem Set
// URL: https://cses.fi/problemset/task/1674
// Memory Limit: 512 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

#include <bits/stdc++.h>
using namespace std;

void dfs(int node, vector<vector<int>> &tree, vector<long long> &sub, vector<bool> &vis, int n){
	vis[node] = true;
	for(int i=0;i<(int)tree[node].size();i++){
		int neigh = tree[node][i];
		if(!vis[neigh]){
			dfs(neigh, tree, sub, vis, n);
			sub[node]+=sub[neigh];
		}
	}
}
int main(){
	int n;
	cin>>n;
	vector<vector<int>> arr;
	vector<bool> vis(n+1,false);
	vector<long long> sub(n+1,0);
	for(int i=0;i<=n;i++){
		vector<int> b;
		arr.push_back(b);
	}
	int boss;
	for(int i=2;i<=n;i++){
		cin>>boss;
		arr[boss].push_back(i);
	}
	for(int i=1;i<=n;i++){
		sub[i]=arr[i].size();
	}
// 	for(int i=1;i<=n;i++){
// 	    cout<<i<<"CHILDREN"<<endl;
// 		for(int j=0;j<arr[i].size();j++){
// 			cout<<arr[i][j]<<" ";
// 		}
// 		cout<<endl;
// 	}
	dfs(1,arr,sub,vis,n);
	for(int i=1;i<=n;i++){
		cout<<sub[i]<<" ";
	}
	
}