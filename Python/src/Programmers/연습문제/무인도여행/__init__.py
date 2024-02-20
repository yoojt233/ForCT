from collections import deque


def solution(maps):
    row = len(maps)
    col = len(maps[0])
    visited = [[False for _ in range(col)] for _ in range(row)]
    res = []

    for i in range(row):
        for j in range(col):
            if maps[i][j] == 'X' or visited[i][j]: continue
            visited[i][j] = True
            res.append(bfs(row, col, maps, visited, i, j, int(maps[i][j])))

    return sorted(res) if res else [-1]


def bfs(row, col, maps, visited, i, j, cnt) -> int:
    q = deque([(i, j)])
    dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while q:
        r, c = q.popleft()
        for d in range(4):
            dx, dy = dir[d]
            nr, nc = r + dx, c + dy

            if nr not in range(row) or nc not in range(col) or maps[nr][nc] == 'X' or visited[nr][nc]: continue
            visited[nr][nc] = True
            cnt += int(maps[nr][nc])
            q.append((nr, nc))

    return cnt


maps = ["XXX", "XXX", "XXX"]
print(solution(maps))
