def solution(board, skill):
    n, m = len(board), len(board[0])
    arr = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    res = 0

    for temp in skill:
        r1, c1, r2, c2 = temp[1], temp[2], temp[3] + 1, temp[4] + 1
        damage = -temp[5] if temp[0] == 1 else temp[5]

        arr[r1][c1] += damage
        arr[r1][c2] -= damage
        arr[r2][c1] -= damage
        arr[r2][c2] += damage

    for i in range(n + 1):
        for j in range(1, m + 1):
            arr[i][j] += arr[i][j - 1]

    for i in range(1, n + 1):
        for j in range(m + 1):
            arr[i][j] += arr[i - 1][j]

    for i in range(n):
        for j in range(m):
            board[i][j] += arr[i][j]
            if board[i][j] > 0: res += 1

    return res


board = [[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]]
skill = [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]
print(solution(board, skill))
