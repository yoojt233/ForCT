import sys
from collections import deque

input = sys.stdin.readline


def check(r, c, isWidth):
    global dir, board, visited
    dq = deque([])
    dq.append((r, c))

    cnt = 1
    while dq:
        cr, cc = dq.popleft()
        nr, nc = cr + dir[isWidth][0], cc + dir[isWidth][1]

        if nr < 0 or nr >= n or nc < 0 or nc >= n: continue
        if visited[nr][nc][isWidth] or board[nr][nc] == 'X': continue

        visited[nr][nc][isWidth] = True
        dq.append((nr, nc))
        cnt += 1

    return True if cnt > 1 else False


n = int(input().rstrip())
dir = [(0, 1), (1, 0)]
board = [input().rstrip() for _ in range(n)]
visited = [[[False, False] for _ in range(n)] for _ in range(n)]
res = [0, 0]

for i in range(n):
    for j in range(n):
        if board[i][j] == 'X': continue

        if not visited[i][j][0]:
            visited[i][j][0] = True
            if check(i, j, 0): res[0] += 1

        if not visited[i][j][1]:
            visited[i][j][1] = True
            if check(i, j, 1): res[1] += 1

print("%d %d" % (res[0], res[1]))
