import sys

input = sys.stdin.readline

board = [list(map(int, input().rstrip().split())) for _ in range(10)]
papers = [5 for _ in range(5)]


def isPossible(r, c, l):
    for i in range(r, r + l + 1):
        for j in range(c, c + l + 1):
            if board[i][j] != 1: return False
    return True


def cover(r, c, l, flag):
    if flag == 0:
        papers[l] -= 1
    else:
        papers[l] += 1

    for i in range(r, r + l + 1):
        for j in range(c, c + l + 1):
            board[i][j] = flag


def dfs(r, c, cnt):
    global total

    if r == 10:
        total = min(total, cnt)
        return

    if c == 10:
        dfs(r + 1, 0, cnt)
        return

    if board[r][c] == 1:
        for x in range(5):
            if papers[x] == 0 or r + x >= 10 or c + x >= 10: continue
            if not isPossible(r, c, x): break
            cover(r, c, x, 0)
            dfs(r, c + x + 1, cnt + 1)
            cover(r, c, x, 1)
    else:
        dfs(r, c + 1, cnt)


total = 100
dfs(0, 0, 0)
print(-1 if total == 100 else total)
