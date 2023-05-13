import sys


def adv_input():
    return sys.stdin.readline().rstrip()


def solve(level, total):
    global ans
    if level == N:
        return

    if total + nums[level] == s:
        ans += 1

    solve(level + 1, total)
    solve(level + 1, total + nums[level])


N, s = map(int, adv_input().split())
nums = list(map(int, adv_input().split()))
ans = 0

solve(0, 0)
print(ans)
