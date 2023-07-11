import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
visited = [[False for _ in range(m)] for _ in range(n)]

redstone = [set([]) for _ in range(3)]
q = deque([])

for _ in range(int(input())):
    red, r, c = input().rstrip().split()
    _, t = red.split("_")
    if t == "block":
        redstone[0].add((int(r), int(c)))
        q.append((int(r), int(c)))
    elif t == "dust":
        redstone[1].add((int(r), int(c)))
    else:
        redstone[2].add((int(r), int(c)))

power = 15
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
while q:
    size = len(q)
    for _ in range(size):
        cur = q.popleft()
        for d in range(4):
            nr = cur[0] + dx[d]
            nc = cur[1] + dy[d]

            if nr < 0 or nr >= n or nc < 0 or nc >= m or visited[nr][nc]: continue
            if (nr, nc) in redstone[1]:
                visited[nr][nc] = True
                q.append((nr, nc))
            elif (nr, nc) in redstone[2]:
                visited[nr][nc] = True
    power -= 1
    if power == 0: break

flag = True
for (r, c) in redstone[2]:
    if not visited[r][c]:
        flag = False
        break

print("success" if flag else "failed")
