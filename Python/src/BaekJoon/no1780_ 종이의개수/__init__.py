import sys

input = sys.stdin.readline


def divide(n, r, c):
    x = board[r][c]

    if n == 1:
        cnt[x] += 1
        return

    for i in range(r, r + n):
        for j in range(c, c + n):
            if board[i][j] == x: continue

            for a in range(r, r + n, n // 3):
                for b in range(c, c + n, n // 3):
                    divide(n // 3, a, b)
            return

    cnt[x] += 1


n = int(input().rstrip())
board = [list(map(int, input().rstrip().split())) for _ in range(n)]
cnt = {-1: 0, 0: 0, 1: 0}
divide(n, 0, 0)

for v in cnt.values():
    print(v)
