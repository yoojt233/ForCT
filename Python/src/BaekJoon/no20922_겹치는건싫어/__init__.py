import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
nums = list(map(int, input().rstrip().split()))

chance = [deque([]) for _ in range(100001)]

ans = 0
left, right = 0, 0
while right < n:
    cur = nums[right]
    if len(chance[cur]) >= k:
        temp = chance[cur].popleft()
        for i in range(left, temp + 1):
            dq = chance[nums[i]]
            while dq and dq[0] <= temp:
                dq.popleft()
        left = temp + 1
    chance[cur].append(right)
    right += 1
    ans = max(ans, right - left)

print(ans)
