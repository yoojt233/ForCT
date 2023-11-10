import sys

input = sys.stdin.readline


def combo(level, op, sel):
    global ans

    if level == m:
        temp = 0
        for i in range(m - 1):
            x = sel[i]
            for j in range(i + 1, m):
                temp += ingredients[x][sel[j]]
        ans = max(ans, temp)
        return

    for i in range(op, n):
        sel[level] = i
        combo(level + 1, i + 1, sel)


n, m = map(int, input().rstrip().split())
ingredients = [list(map(int, input().rstrip().split())) for _ in range(n)]

ans = -50000
combo(0, 0, [0 for _ in range(m)])
print(ans)
