#include <bits/stdc++.h>
using namespace std;

int main() {    
    int n, q;   
    cin >> n >> q;
    
    vector<string> forest(n + 1);
    for (int i = 1; i <= n; ++i)
        cin >> forest[i];
    
    vector<vector<int>> pref(n + 1, vector<int>(n + 1, 0));
    
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            int isTree = (forest[i][j - 1] == '*') ? 1 : 0;
            pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + isTree;
        }
    }
    
    while (q--) {
        int y1, x1, y2, x2;
        cin >> y1 >> x1 >> y2 >> x2;
        
        int ans = pref[y2][x2] - pref[y1 - 1][x2] - pref[y2][x1 - 1] + pref[y1 - 1][x1 - 1];
        cout << ans << endl;
    }
    
    return 0;
}
