import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
staff = list(map(int, input().rstrip().split()))

left, right = 1, min(staff) * m
ans = right
while left <= right:
    mid = (left + right) // 2
    temp = sum([mid // s for s in staff])

    if temp < m:
        left = mid + 1
    else:
        right = mid - 1
        ans = min(ans, mid)

print(int(ans))
