import sys

input = sys.stdin.readline


def switch(r, c):
    for i in range(r + 1):
        for j in range(c + 1):
            coins[i][j] = 0 if coins[i][j] == 1 else 1


n, m = map(int, input().rstrip().split())
coins = [[0 for _ in range(m)] for _ in range(n)]
for i in range(n):
    temp = input().rstrip()
    for j in range(m):
        coins[i][j] = int(temp[j])

ans = 0
for i in reversed(range(n)):
    for j in reversed(range(m)):
        if coins[i][j] == 1:
            ans += 1
            switch(i, j)

print(ans)
