import sys


def adv_input():
    return sys.stdin.readline().rstrip()


def solve(level, cnt, total, op):
    if level == cnt:
        if s == total:
            global ans
            ans += 1
        return
    for i in range(op, N):
        solve(level + 1, cnt, total + origin[i], i + 1)


N, s = map(int, adv_input().split())
origin = list(map(int, adv_input().split()))
ans = 0

for i in range(N):
    solve(0, i + 1, 0, 0)

print(ans)
