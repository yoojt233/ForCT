def solution(n, m, x, y, queries):
    op, ed = [x, y], [x, y]

    for dir, dist in reversed(queries):
        if dir == 0:
            ed[1] = min(ed[1] + dist, m - 1)

            if op[1] != 0: op[1] += dist
        elif dir == 1:
            op[1] = max(op[1] - dist, 0)

            if ed[1] != m - 1: ed[1] -= dist
        elif dir == 2:
            ed[0] = min(ed[0] + dist, n - 1)

            if op[0] != 0: op[0] += dist
        else:
            op[0] = max(op[0] - dist, 0)

            if ed[0] != n - 1: ed[0] -= dist

        if op[0] > n - 1 or op[1] > m - 1 or ed[0] < 0 or ed[1] < 0: return 0

    return (ed[0] - op[0] + 1) * (ed[1] - op[1] + 1)


n, m = 2, 5
x, y = 0, 1
queries = [[3, 1], [2, 2], [1, 1], [2, 3], [0, 1], [2, 1]]

print(solution(n, m, x, y, queries))
