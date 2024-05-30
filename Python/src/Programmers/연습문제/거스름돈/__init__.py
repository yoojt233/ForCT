def solution(n, money):
    mod = 1_000_000_007
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1

    for coin in money:
        for cur in range(coin, n + 1):
            dp[cur] = (dp[cur] + dp[cur - coin]) % mod

    return dp[-1]


n = 5
money = [1, 2, 5]
print(solution(n, money))
