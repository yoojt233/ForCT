def solution(n):
    if n % 2 != 0: return 0

    mod = 1_000_000_007
    dp = [(1, 1), (3, 4)]

    for _ in range(1, n // 2):
        next = (dp[-1][1] * 2 + dp[-1][0]) % mod
        dp.append((next, (dp[-1][1] + next) % mod))

    return dp[-1][0]


print(solution(n=4))
