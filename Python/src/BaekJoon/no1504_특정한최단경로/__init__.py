import sys
import heapq

input = sys.stdin.readline
INF = 1e8


def dijkstra(op):
    dist = [INF for _ in range(n)]
    dist[op] = 0

    hq = []
    heapq.heappush(hq, (op, 0))

    while hq:
        cur, d = heapq.heappop(hq)
        if dist[cur] < d: continue
        for next, cost in graph[cur]:
            if d + cost < dist[next]:
                dist[next] = d + cost
                heapq.heappush(hq, (next, dist[next]))

    return dist


n, e = map(int, input().rstrip().split())

graph = [[] for _ in range(n)]
for i in range(e):
    a, b, c = map(int, input().rstrip().split())
    graph[a - 1].append((b - 1, c))
    graph[b - 1].append((a - 1, c))

v1, v2 = map(int, input().rstrip().split())
x = dijkstra(0)
y = dijkstra(v1 - 1)
z = dijkstra(v2 - 1)
ans = min(x[v1 - 1] + y[v2 - 1] + z[n - 1], x[v2 - 1] + y[n - 1] + z[v1 - 1])
print(ans if ans < INF else -1)
