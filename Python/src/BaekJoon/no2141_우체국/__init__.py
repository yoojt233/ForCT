import sys
from itertools import accumulate

input = sys.stdin.readline

n = int(input().rstrip())
villages = []
for _ in range(n):
    idx, people = map(int, input().rstrip().split())
    villages.append((idx, people))

villages.sort(key=lambda x: x[0])
left, right = 0, list(accumulate([villages[i][1] for i in range(n)]))[-1]

for i in range(n):
    left += villages[i][1]
    right -= villages[i][1]

    if left >= right:
        print(villages[i][0])
        break
