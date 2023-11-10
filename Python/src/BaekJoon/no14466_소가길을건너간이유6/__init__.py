import sys


def adv_input():
    return sys.stdin.readline().rstrip()


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(r, c):
    q = [(r, c)]
    while q:
        cr, cc = q.pop(0)
        for d in range(4):
            nr = cr + dx[d]
            nc = cc + dy[d]

            if nr < 0 or nr >= N or nc < 0 or nc >= N or visited[nr][nc] or (nr, nc) in bridge[cr][cc]: continue
            q.append((nr, nc))
            visited[nr][nc] = True


N, K, R = map(int, adv_input().split())
bridge = [[[] for _ in range(N)] for _ in range(N)]
ans = 0

for _ in range(R):
    r1, c1, r2, c2 = map(lambda x: int(x) - 1, adv_input().split())
    bridge[r1][c1].append((r2, c2))
    bridge[r2][c2].append((r1, c1))

cows = []
for _ in range(K):
    r, c = map(lambda x: int(x) - 1, adv_input().split())
    cows.append((r, c))

for i in range(len(cows)):
    visited = [[False for _ in range(N)] for _ in range(N)]
    cur = cows[i]
    visited[cur[0]][cur[1]] = True
    bfs(cur[0], cur[1])
    for (dr, dc) in cows[i + 1:]:
        if not visited[dr][dc]: ans += 1

print(ans)
