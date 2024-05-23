import sys

input = sys.stdin.readline

ans = 0
for i in range(1, int(input().rstrip()) + 1):
    while True:
        if i % 5 != 0: break
        ans += 1
        i //= 5

print(ans)
