import sys

input = sys.stdin.readline

n, x = map(int, input().rstrip().split())
visitors = list(map(int, input().rstrip().split()))
sums = [sum(visitors[0:x])]
for i in range(x, n):
    sums.append(sums[-1] + visitors[i] - visitors[i - x])

temp = max(sums)
if temp == 0:
    print("SAD")
else:
    print(temp)
    print(sums.count(temp))
