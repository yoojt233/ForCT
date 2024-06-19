def solution(m, n, puddles):
    board = [[0] * (m + 1) for _ in range(n + 1)]
    dir = [(-1, 0), (0, -1)]
    puddles = set(list(map(tuple, puddles)))

    board[1][1] = 1
    mod = 1_000_000_007

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (j, i) in puddles: continue

            for d in range(2):
                board[i][j] = (board[i][j] + board[i + dir[d][0]][j + dir[d][1]]) % mod

    return board[n][m]


print(solution(m=4, n=3, puddles=[[2, 2]]))
