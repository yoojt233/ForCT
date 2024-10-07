def find(points, route):
    r, c = points[route[0] - 1]
    path = [(r, c)]

    for i in range(1, len(route)):
        tr, tc = points[route[i] - 1]

        while r != tr:
            r = r + 1 if r < tr else r - 1
            path.append((r, c))

        while c != tc:
            c = c + 1 if c < tc else c - 1
            path.append((r, c))

    return path


def solution(points, routes):
    res = 0
    board = [[0] * 101 for _ in range(101)]
    paths, length = [], []

    for route in routes:
        paths.append(find(points, route))
        length.append(len(paths[-1]))

    for j in range(max(length)):
        for i in range(len(routes)):
            if j >= length[i]: continue

            r, c = paths[i][j]
            board[r][c] += 1

            if board[r][c] == 2: res += 1

        for i in range(len(routes)):
            if j >= length[i]: continue

            r, c = paths[i][j]
            board[r][c] -= 1

    return res


points = [[3, 2], [6, 4], [4, 7], [1, 4]]
routes = [[4, 2], [1, 3], [4, 2], [4, 3]]

print(solution(points, routes))
