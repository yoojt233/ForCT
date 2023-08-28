import sys
from collections import deque

input = sys.stdin.readline


def bfs(q):
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    visited = [[False for _ in range(m)] for _ in range(n)]
    ans = [[0 for _ in range(m)] for _ in range(n)]
    visited[q[0][0]][q[0][1]] = True
    while q:
        cur = q.popleft()
        for d in range(4):
            nr, nc = cur[0] + dx[d], cur[1] + dy[d]
            if nr not in range(0, n) or nc not in range(0, m) or board[nr][nc] == 0 or visited[nr][nc]: continue

            ans[nr][nc] = ans[cur[0]][cur[1]] + 1
            visited[nr][nc] = True
            q.append((nr, nc))

    for i in range(n):
        for j in range(m):
            print(-1 if not visited[i][j] and board[i][j] != 0 else ans[i][j], end=" ")
        print()


n, m = map(int, input().rstrip().split())
flag = False
board = []
q = deque([])
for i in range(n):
    temp = list(map(int, input().rstrip().split()))
    board.append(temp)
    if flag: continue
    for j in range(m):
        if temp[j] == 2:
            q.append((i, j))
            flag = True
            break

bfs(q)
