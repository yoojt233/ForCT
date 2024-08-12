import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
board = [[0] * (m + 1) for _ in range(n + 1)]
board[0][0] = 1

impo = set()
for _ in range(int(input().rstrip())):
    a, b, c, d = map(int, input().rstrip().split())
    impo.add((a, b, c, d) if (a + b) <= (c + d) else (c, d, a, b))

for c in range(m):
    if (0, c, 0, c + 1) not in impo:
        board[0][c + 1] = 1
    else:
        break

for r in range(n):
    if (r, 0, r + 1, 0) not in impo:
        board[r + 1][0] = 1
    else:
        break

for r in range(1, n + 1):
    for c in range(1, m + 1):
        if (r - 1, c, r, c) not in impo: board[r][c] += board[r - 1][c]
        if (r, c - 1, r, c) not in impo: board[r][c] += board[r][c - 1]

print(board[n][m])
