import sys
import bisect

input = sys.stdin.readline

n, m = map(int, input().split())
panels = ["" for _ in range(n)]
scores = [0 for _ in range(n)]
for i in range(n):
    panels[i], score = input().split()
    scores[i] = int(score)

for _ in range(m):
    print(panels[bisect.bisect_left(scores, int(input()))])
