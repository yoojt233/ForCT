import sys

input = sys.stdin.readline

N = int(input().rstrip())
M = int(input().rstrip())
S = input().rstrip()

ans, left, right = 0, 0, 0

while right < M:
    if S[right:right + 3] == 'IOI':
        right += 2
        if right - left == N * 2:
            ans += 1
            left += 2
    else:
        right += 1
        left = right

print(ans)
