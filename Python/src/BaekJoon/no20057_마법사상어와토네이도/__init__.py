import sys

input = sys.stdin.readline


def percent(a, b):
    return a * b // 100


def move(pos, where):
    global ans
    if pos[1] < 0: return

    total = 0
    sand = board[pos[0]][pos[1]]

    for x, y, p in where:
        nr, nc = pos[0] + x, pos[1] + y

        if p > 0:
            temp = percent(sand, p)
            total += temp
        else:
            temp = board[pos[0]][pos[1]] - total

        if nr in range(n) and nc in range(n):
            board[nr][nc] += temp
        else:
            ans += temp

    board[pos[0]][pos[1]] = 0


dx, dy = [0, 1, 0, -1], [-1, 0, 1, 0]
left = [(0, -2, 5), (-1, -1, 10), (-1, 0, 7), (-2, 0, 2), (-1, 1, 1), (1, -1, 10), (1, 0, 7), (2, 0, 2),
        (1, 1, 1), (0, -1, 0)]
right = [(x, -y, p) for x, y, p in left]
up = [(y, x, p) for x, y, p in left]
down = [(-y, x, p) for x, y, p in left]
dir = {0: left, 1: down, 2: right, 3: up}

n = int(input().rstrip())
board = [list(map(int, input().rstrip().split())) for _ in range(n)]
ans = 0

op = [n // 2, n // 2]
cnt, d = 0, 0
while op[0] + op[1] > 0:
    if d % 2 == 0:
        cnt += 1

    for _ in range(cnt):
        op[0] += dx[d]
        op[1] += dy[d]
        move(op, dir[d])

    d = (d + 1) % 4

print(ans)
