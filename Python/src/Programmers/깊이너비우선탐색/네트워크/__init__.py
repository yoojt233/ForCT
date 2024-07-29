def solution(n, computers):
    parent = [i for i in range(n)]

    for i in range(n):
        for j in range(i + 1, n):
            if computers[i][j] == 0: continue
            union(i, j, parent)

    root = []
    for p in parent:
        r = find(p, parent)
        if r not in root: root.append(r)

    return len(root)


def union(a, b, parent):
    ra = find(a, parent)
    rb = find(b, parent)

    if ra != rb: parent[rb] = ra


def find(x, parent):
    if parent[x] != x: parent[x] = find(parent[x], parent)
    return parent[x]


print(solution(n=3, computers=[[1, 1, 0], [1, 1, 1], [0, 1, 1]]))
