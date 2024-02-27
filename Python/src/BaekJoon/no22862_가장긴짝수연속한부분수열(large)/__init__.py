import sys

input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
nums = list(map(int, input().rstrip().split()))

ed, odd, ans = 0, 0, 0

for op in range(n):
    while odd <= k and ed < n:
        if nums[ed] % 2 == 1: odd += 1
        ed += 1

        if ed >= n:
            ans = max(ans, ed - op - odd)
            break

    if odd > k: ans = max(ans, ed - op - odd)
    if nums[op] % 2 == 1: odd -= 1

print(ans)
