import sys
import bisect


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
files = list(map(int, adv_input().split()))
files.sort()

res = 0
for size in files:
    res += bisect.bisect_left(files, size * 0.9)
print((n - 1) * n // 2 - res)
