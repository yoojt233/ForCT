import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def find(x) -> int:
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]


def union(x, y) -> bool:
    xr, yr = find(x), find(y)
    if xr != yr: parents[yr] = xr
    return xr == yr


N, M = map(int, input().rstrip().split())

ans = 0
parents = [i for i in range(N)]
for _ in range(M):
    u, v = map(int, input().rstrip().split())
    if union(u - 1, v - 1):
        ans += 1

roots = set([])
for i in range(N):
    roots.add(find(i))

ans += len(roots) - 1
print(ans)
