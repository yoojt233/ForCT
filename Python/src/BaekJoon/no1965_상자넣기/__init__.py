import sys
import bisect

input = sys.stdin.readline

n = int(input().rstrip())
boxes = list(map(int, input().rstrip().split()))

dp = [boxes[0]]
for i in range(1, n):
    box = boxes[i]
    if box > dp[-1]:
        dp.append(box)
    else:
        where = bisect.bisect_left(dp, box)
        dp[where] = box
        
print(len(dp))
