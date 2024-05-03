from collections import deque


def solution(n, edge):
    graph = [[] for _ in range(n)]
    visited = [n for _ in range(n)]
    levels = [0 for _ in range(n)]

    for a, b in edge:
        graph[a - 1].append(b - 1)
        graph[b - 1].append(a - 1)

    dq = deque([0])
    farther, visited[0] = 0, 0

    while dq:
        cur = dq.popleft()
        dist = visited[cur]

        if dist > farther: farther = dist
        if visited[cur] == dist: levels[dist] += 1

        for next in graph[cur]:
            if visited[next] <= dist + 1: continue
            visited[next] = dist + 1
            dq.append(next)

    return levels[farther]


n = 6
vertex = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
print(solution(n, vertex))
