import math
import sys
from collections import deque


def adv_input():
    return sys.stdin.readline().rstrip()


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(r, c) -> int:
    cnt = 1
    q = deque([(r, c)])
    while q:
        cr, cc = q.popleft()
        for d in range(4):
            nr = cr + dx[d]
            nc = cc + dy[d]

            if nr < 0 or nr >= n or nc < 0 or nc >= n or board[nr][nc] != 0: continue
            board[nr][nc] = 2
            cnt += 1
            q.append((nr, nc))

    return cnt


n, m, k = map(int, adv_input().split())
board = [list(map(int, adv_input().split())) for _ in range(n)]

flag = True
mush = 0
for i in range(n):
    if not flag: break
    for j in range(n):
        if board[i][j] != 0: continue
        board[i][j] = 2

        blank = bfs(i, j)
        mush += math.ceil(blank / k)
        if m - mush < 0:
            flag = False
            break

if not flag or mush == 0:
    print("IMPOSSIBLE")
else:
    print("POSSIBLE")
    print(m - mush)
