import sys
from queue import Queue


def adv_input():
    return sys.stdin.readline().rstrip()


N = int(adv_input())
bridge = list(map(int, adv_input().split()))
op, ed = map(int, adv_input().split())

q = Queue()
q.put(op - 1)
visited = [-1] * N
visited[op - 1] = 0

while not q.empty():
    cur = q.get()
    if abs((ed - 1 - cur) % bridge[cur] == 0):
        visited[ed - 1] = visited[cur] + 1
        break

    for next in range(cur + bridge[cur], N, bridge[cur]):
        if visited[next] == -1:
            q.put(next)
            visited[next] = visited[cur] + 1

    for next in range(cur - bridge[cur], -1, -bridge[cur]):
        if visited[next] == -1:
            q.put(next)
            visited[next] = visited[cur] + 1

print(visited[ed - 1])
