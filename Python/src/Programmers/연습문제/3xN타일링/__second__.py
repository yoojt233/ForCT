def solution(n):
    if n % 2 != 0: return 0

    # dp[0] = 1, dp[i] = dp[i-2]*4 - dp[i-4]
    mod = 1_000_000_007
    a = b = 1

    for _ in range(n // 2): a, b = b, (4 * b - a) % mod

    return b


print(solution(n=4))
