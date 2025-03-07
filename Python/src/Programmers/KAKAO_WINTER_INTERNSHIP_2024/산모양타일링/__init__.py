def solution(n, tops):
    dp = [0, 1]

    for i in range(n):
        next = (dp[i + 1] * 3) % 10007 - dp[i]

        if tops[i] == 1: next += dp[i + 1]

        dp.append(next % 10007)

    return dp[-1]


n = 4
tops = [1, 1, 0, 1]
print(solution(n, tops))
