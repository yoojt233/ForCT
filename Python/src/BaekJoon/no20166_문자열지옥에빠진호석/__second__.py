import sys

input = sys.stdin.readline


def dfs(r, c, level, path):
    if path in dict:
        dict[path] += 1

    if level == limit:
        return

    for d in range(8):
        nr, nc = (r + dx[d]) % n, (c + dy[d]) % m
        dfs(nr, nc, level + 1, path + board[nr][nc])


n, m, k = map(int, input().rstrip().split())
board = [input().rstrip() for _ in range(n)]
targets = [input().rstrip() for _ in range(k)]

dx, dy = [0, 0, -1, 1, -1, -1, 1, 1], [-1, 1, 0, 0, -1, 1, -1, 1]
dict = {}
limit = 0

for target in targets:
    limit = max(limit, len(target))
    dict[target] = 0

for i in range(n):
    for j in range(m):
        dfs(i, j, 1, board[i][j])

for target in targets:
    print(dict[target])
