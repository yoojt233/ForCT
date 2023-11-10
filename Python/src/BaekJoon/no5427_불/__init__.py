from collections import deque
import sys


def adv_input():
    return sys.stdin.readline().rstrip();


class Pos:
    def __init__(self, r, c):
        self.r = r
        self.c = c


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    ans = 0
    while q:
        f = len(fires)
        for i in range(f):
            cur = fires.popleft()
            for d in range(4):
                nr = cur.r + dx[d]
                nc = cur.c + dy[d]

                if 0 <= nr < n and 0 <= nc < m and board[nr][nc] == '.':
                    board[nr][nc] = '*'
                    fires.append(Pos(nr, nc))

        p = len(q)
        for i in range(p):
            cur = q.popleft()
            for d in range(4):
                nr = cur.r + dx[d]
                nc = cur.c + dy[d]

                if 0 <= nr < n and 0 <= nc < m:
                    if visited[nr][nc] or board[nr][nc] != '.': continue
                    visited[nr][nc] = True
                    q.append(Pos(nr, nc))
                else:
                    return ans + 1
        ans += 1

    return "IMPOSSIBLE"


for t in range(int(adv_input())):
    m, n = map(int, adv_input().split())

    board = []
    fires = deque()
    visited = [[False] * m for i in range(n)]
    q = deque()
    for i in range(n):
        temp = adv_input()
        floor = []
        for j in range(m):
            if temp[j] == '@':
                q.append(Pos(i, j))
                visited[i][j] = True
                floor.append('.')
            elif temp[j] == '*':
                fires.append(Pos(i, j))
                floor.append('*')
            else:
                floor.append(temp[j])
        board.append(floor)

    print(bfs())
