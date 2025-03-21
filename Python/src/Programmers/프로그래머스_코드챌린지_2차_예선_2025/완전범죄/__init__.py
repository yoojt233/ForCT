def solution(info, n, m):
    dp = [[[False] * m for _ in range(n)] for _ in range(len(info) + 1)]
    dp[0][0][0] = True

    for i in range(len(info)):
        x, y = info[i]

        for a in range(n):
            for b in range(m):
                if dp[i][a][b]:
                    na = a + x
                    nb = b + y

                    if na < n: dp[i + 1][na][b] = True
                    if nb < m: dp[i + 1][a][nb] = True

    for a in range(n):
        for b in range(m):
            if dp[len(info)][a][b]:
                return a

    return -1


info = [[1, 2], [2, 3], [2, 1]]
n = 1
m = 7

print(solution(info, n, m))
