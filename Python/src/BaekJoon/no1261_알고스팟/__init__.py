import sys
import heapq

input = sys.stdin.readline


class Pos:
    def __init__(self, wall, r, c):
        self.r = r
        self.c = c
        self.wall = wall

    def __lt__(self, other):
        if self.wall < other.wall:
            return True
        return False


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

m, n = map(int, input().rstrip().split())
board = [[0 for _ in range(m)] for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
visited[0][0] = True

for i in range(n):
    temp = input().rstrip()
    for j in range(m):
        board[i][j] = int(temp[j])

hq = []
heapq.heappush(hq, Pos(0, 0, 0))
while hq:
    cur = heapq.heappop(hq)
    if cur.r == n - 1 and cur.c == m - 1:
        print(cur.wall)
        break

    for d in range(4):
        nr = cur.r + dx[d]
        nc = cur.c + dy[d]
        if nr < 0 or nr >= n or nc < 0 or nc >= m or visited[nr][nc]: continue
        heapq.heappush(hq, Pos(cur.wall, nr, nc) if board[nr][nc] == 0 else Pos(cur.wall + 1, nr, nc))
        visited[nr][nc] = True
