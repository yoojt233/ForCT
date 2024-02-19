dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]


def solution(board):
    n = len(board)
    m = len(board[0])

    visited = [[False for _ in range(m)] for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                op = (i, j, 0)
                visited[i][j] = True
                break

    q = [op]

    while q:
        r, c, level = q.pop(0)

        for d in range(4):
            nr, nc, nl = move(board, r, c, level, n, m, d)

            if visited[nr][nc]:
                continue
            elif board[nr][nc] == 'G':
                return nl

            visited[nr][nc] = True
            q.append((nr, nc, nl))

    return -1


def move(board, r, c, level, n, m, d):
    nr, nc = r, c

    while True:
        nr += dx[d]
        nc += dy[d]

        if (nr not in range(n)) or (nc not in range(m) or board[nr][nc] == 'D'):
            return nr - dx[d], nc - dy[d], level + 1


board = [".D.R", "....", ".G..", "...D"]
print(solution(board))
