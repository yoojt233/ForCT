import sys

input = sys.stdin.readline

S = input().rstrip()
P = input().rstrip()
op = 0

ans = 0
for i in range(len(P)):
    if S.find(P[op:i + 1]) != -1: continue
    op = i
    ans += 1
print(ans + 1)
