import sys

input = sys.stdin.readline


def mark(r, c):
    global board

    expr = board[r + 1][c + 1: c + 7]
    flag = expr[-1] == '.'
    res = int(expr[-2]) if flag else int(expr[-2]) * 10 + int(expr[-1])

    if int(expr[0]) + int(expr[2]) != res:
        for i in range(3):
            board[r + i][c + 3 - i] = '/'
    else:
        last = 5 if flag else 6
        for i in range(last):
            board[r][c + i + 1] = '*'
            board[r + 2][c + i + 1] = '*'
        board[r + 1][c] = '*'
        board[r + 1][c + last + 1] = '*'


n, m = map(int, input().rstrip().split())
board = [list(input().rstrip()) for _ in range(3 * n)]

for i in range(n):
    for j in range(m):
        mark(3 * i, 8 * j)

for line in board:
    print(''.join(line))
