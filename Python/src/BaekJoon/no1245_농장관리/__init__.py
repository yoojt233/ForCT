import sys

input = sys.stdin.readline


def isTop(r, c):
    for d in range(8):
        nr, nc = r + dxdy[d][0], c + dxdy[d][1]

        if nr not in range(n) or nc not in range(m): continue
        if board[nr][nc] > board[r][c]: return False

    return True


def bfs(i, j):
    visited = [[False] * m for _ in range(n)]
    visited[i][j] = True

    q = [(i, j)]
    while q:
        r, c = q.pop(0)

        for d in range(8):
            nr, nc = r + dxdy[d][0], c + dxdy[d][1]

            if nr not in range(n) or nc not in range(m) or visited[nr][nc] or board[nr][nc] == 0: continue
            if board[r][c] == board[nr][nc]:
                if not isTop(nr, nc): return False

                visited[nr][nc] = True
                checked[nr][nc] = True
                q.append((nr, nc))

    return True


n, m = map(int, input().rstrip().split())
board = [list(map(int, input().rstrip().split())) for _ in range(n)]
checked = [[False] * m for _ in range(n)]

dxdy = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]
ans = 0

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 or checked[i][j]: continue
        if isTop(i, j) and bfs(i, j): ans += 1

print(ans)
