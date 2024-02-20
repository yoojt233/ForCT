import sys

input = sys.stdin.readline


def calc(snacks, v):
    res = 0
    for snack in snacks:
        res += (snack // v)
    return res


m, n = map(int, input().split())
snacks = list(map(int, input().split()))
left, right, ans = 1, max(snacks), 0

while left <= right:
    mid = (left + right) // 2
    total = calc(snacks, mid)

    if total >= m:
        left = mid + 1
        ans = mid
    else:
        right = mid - 1

print(ans)
