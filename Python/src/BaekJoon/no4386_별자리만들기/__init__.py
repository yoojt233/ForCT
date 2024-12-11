import sys, math
from collections import deque

input = sys.stdin.readline


class Edge:
    def __init__(self, a, b, dist):
        self.a = a
        self.b = b
        self.dist = dist

    def __lt__(self, other):
        return self.dist < other.dist


def find(x):
    if parent[x] != x: parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    ar = find(a)
    br = find(b)

    if cnt[ar] > cnt[br]:
        parent[br] = ar
        cnt[ar] += cnt[br]
        cnt[br] = 0
    else:
        parent[ar] = br
        cnt[br] += cnt[ar]
        cnt[ar] = 0


n = int(input().rstrip())
parent = [i for i in range(n)]
cnt = [1 for _ in range(n)]
stars, edges = [], []
ans, connect = 0, 0

for _ in range(n):
    x, y = map(float, input().rstrip().split())
    stars.append((x, y))

for i in range(n - 1):
    for j in range(i + 1, n):
        dist = math.sqrt((stars[i][0] - stars[j][0]) ** 2 + (stars[i][1] - stars[j][1]) ** 2)
        edges.append(Edge(i, j, dist))

edges.sort()
dq = deque(edges)

while connect < n - 1:
    cur = dq.popleft()

    if find(cur.a) != find(cur.b):
        union(cur.a, cur.b)
        ans += cur.dist
        connect += 1

print(ans)
