import sys

input = sys.stdin.readline


def right(r1, c1, r2, c2):
    temp = arr[r2][c2]
    for i in range(r2, r1, -1):
        arr[i][c2] = arr[i - 1][c2]
    for j in range(c2, c1, -1):
        arr[r1][j] = arr[r1][j - 1]
    for i in range(r1, r2):
        arr[i][c1] = arr[i + 1][c1]
    for j in range(c1, c2):
        arr[r2][j] = arr[r2][j + 1]
    arr[r2][c2 - 1] = temp


def left(r1, c1, r2, c2):
    temp = arr[r1][c1]
    for j in range(c1, c2):
        arr[r1][j] = arr[r1][j + 1]
    for i in range(r1, r2):
        arr[i][c2] = arr[i + 1][c2]
    for j in range(c2, c1, -1):
        arr[r2][j] = arr[r2][j - 1]
    for i in range(r2, r1, -1):
        arr[i][c1] = arr[i - 1][c1]
    arr[r1 + 1][c1] = temp


def turn(o, dir):
    r1, c1, r2, c2 = o[0] - 1 - o[2], o[1] - 1 - o[2], o[0] - 1 + o[2], o[1] - 1 + o[2]
    for _ in range(o[2]):
        right(r1, c1, r2, c2) if dir == '+' else left(r1, c1, r2, c2)
        r1 += 1
        c1 += 1
        r2 -= 1
        c2 -= 1


def permu(level, oper, visited):
    if level == k:
        for i in range(n):
            global ans
            ans = min(ans, sum(arr[i]))
        return

    for i in range(k):
        if visited[i]: continue
        visited[i] = True
        turn(oper[i], '+')
        permu(level + 1, oper, visited)
        turn(oper[i], '-')
        visited[i] = False


n, m, k = map(int, input().rstrip().split())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]

oper = []
for _ in range(k):
    oper.append(tuple(map(int, input().rstrip().split())))

ans = sys.maxsize
permu(0, oper, [False for _ in range(k)])
print(ans)
