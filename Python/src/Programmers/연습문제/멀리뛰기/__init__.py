def solution(n):
    mod = 1234567
    dp = [0]
    dp.append(1)
    dp.append(2)

    for i in range(3, n + 1):
        dp.append((dp[i - 1] + dp[i - 2]) % mod)

    return dp[n]


n = 3
print(solution(n))
