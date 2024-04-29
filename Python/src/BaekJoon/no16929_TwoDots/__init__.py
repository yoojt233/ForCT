import sys

input = sys.stdin.readline


def dfs(r, c, target, cnt):
    global flag

    if flag: return

    if visited[r][c] != 0:
        flag = (cnt - visited[r][c]) >= 3
        return

    visited[r][c] = cnt
    for d in range(4):
        nr, nc = r + dx[d], c + dy[d]
        if not 0 <= nr < n or not 0 <= nc < m or board[nr][nc] != target: continue
        dfs(nr, nc, target, cnt + 1)


n, m = map(int, input().rstrip().split())
board = [list(input().rstrip()) for _ in range(n)]

visited = [[0] * m for _ in range(n)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
flag = False

for i in range(n):
    for j in range(m):
        if visited[i][j] != 0: continue
        dfs(i, j, board[i][j], 1)
        if flag: break
    if flag: break

print("Yes" if flag else "No")
