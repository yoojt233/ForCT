import sys

input = sys.stdin.readline


def dfs(r, c, level, path):
    global dict, dp, dx, dy

    if level > 5:
        return

    dict[path] = dict.get(path, 0) + 1

    for d in range(8):
        nr, nc = (r + dx[d]) % n, (c + dy[d]) % m
        next = path + board[nr][nc]
        dfs(nr, nc, level + 1, next)


n, m, k = map(int, input().rstrip().split())
board = [input().rstrip() for _ in range(n)]
dict = {}
dx, dy = [-1, 1, 0, 0, -1, -1, 1, 1], [0, 0, -1, 1, -1, 1, -1, 1]

for i in range(n):
    for j in range(m):
        dfs(i, j, 1, board[i][j])

for _ in range(k):
    print(dict.get(input().rstrip(), 0))
