def solution(matrix_sizes):
    size = len(matrix_sizes)
    dp = [[0] * size for _ in range(size)]

    for cnt in range(1, size):
        for i in range(size - cnt):
            dp[i][i + cnt] = 1e9

            for j in range(i, i + cnt):
                temp = matrix_sizes[i][0] * matrix_sizes[j][1] * matrix_sizes[i + cnt][1]
                dp[i][i + cnt] = min(dp[i][i + cnt], dp[i][j] + temp + dp[j + 1][i + cnt])

    return dp[0][-1]


print(solution(matrix_sizes=[[5, 3], [3, 10], [10, 6]]))
