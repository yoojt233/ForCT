import sys
from collections import deque

input = sys.stdin.readline
board = []
dusts = []
dist = []
ans = sys.maxsize
flag = True


def init(w, h):
    global board, dusts, flag, dist, ans
    board, dist, dusts, ans, flag = [].[], [(0, 0)], sys.maxsize, True

    for i in range(h):
        temp = [c for c in input().rstrip()]
        board.append(temp)
        for j in range(w):
            if temp[j] == 'o':
                dusts[0] = (i, j)
            elif temp[j] == '*':
                dusts.append((i, j))


def bfs(w, h, first):
    global board, dusts, dist, flag

    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

    visited = [[-1 for _ in range(w)] for _ in range(h)]
    visited[first[0]][first[1]] = 0

    q = deque([first])
    while q:
        r, c = q.popleft()
        level = visited[r][c]
        for d in range(4):
            nr = r + dx[d]
            nc = c + dy[d]

            if nr < 0 or nr >= h or nc < 0 or nc >= w or board[nr][nc] == 'x' or visited[nr][nc] != -1: continue
            visited[nr][nc] = level + 1
            q.append((nr, nc))

    res = []
    for i in range(len(dusts)):
        temp = dusts[i]
        x = visited[temp[0]][temp[1]]
        if x == -1:
            flag = False
        res.append(x)
    dist.append(res)


def permu(level, op, total, visited):
    global ans, dist

    if level == len(dusts) - 1:
        ans = min(ans, total)

    for i in range(len(dusts)):
        if i == op or visited[i]: continue
        visited[i] = True
        permu(level + 1, i, total + dist[op][i], visited)
        visited[i] = False


while True:
    w, h = map(int, input().rstrip().split())
    if w == 0 and h == 0: break
    init(w, h)
    for op in dusts:
        if flag: bfs(w, h, op)

    if not flag:
        print(-1)
    else:
        visited = [False for _ in range(len(dusts))]
        visited[0] = True
        permu(0, 0, 0, visited)
        print(ans)
