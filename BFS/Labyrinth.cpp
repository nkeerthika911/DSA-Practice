#include <bits/stdc++.h>
using namespace std;

struct Node {
    int x, y, len;
    string path;
    Node(int _x, int _y, int _len, string _path) {
        x = _x;
        y = _y;
        len = _len;
        path = _path;
    }
};

int main() {
    int R, C;
    cin >> R >> C;
    vector<vector<char>> grid(R, vector<char>(C));
    int startX=0, startY=0, stopX=0, stopY=0;

    for(int row = 0; row < R; row++) {
        string line;
        cin >> line;
        for(int col = 0; col < C; col++) {
            grid[row][col] = line[col];
            if(grid[row][col] == 'A') {
                startX = row;
                startY = col;
            }
            if(grid[row][col] == 'B') {
                stopX = row;
                stopY = col;
            }
        }
    }

    queue<Node> q;
    q.push(Node(startX, startY, 0, ""));
    vector<vector<bool>> visited(R, vector<bool>(C, false));
    visited[startX][startY] = true;

    int dir[4][2] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    char moves[4] = {'R', 'D', 'U', 'L'};

    while(!q.empty()) {
        Node curr = q.front();
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = curr.x + dir[i][0];
            int ny = curr.y + dir[i][1];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C && grid[nx][ny] != '#' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                string newPath = curr.path + moves[i];

                if(grid[nx][ny] == 'B') {
                    cout << "YES\n";
                    cout << curr.len + 1 << "\n";
                    cout << newPath << "\n";
                    return 0;
                }

                q.push(Node(nx, ny, curr.len + 1, newPath));
            }
        }
    }

    cout << "NO\n";
    return 0;
}
