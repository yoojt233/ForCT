def solution(alp, cop, problems):
    max_alp, max_cop = max(p[0] for p in problems), max(p[1] for p in problems)
    dp = [[1e9 for _ in range(max_cop + 1)] for _ in range(max_alp + 1)]
    alp, cop = min(alp, max_alp), min(cop, max_cop)

    dp[alp][cop] = 0
    for ca in range(alp, max_alp + 1):
        for cc in range(cop, max_cop + 1):
            if ca < max_alp:
                dp[ca + 1][cc] = min(dp[ca + 1][cc], dp[ca][cc] + 1)
            if cc < max_cop:
                dp[ca][cc + 1] = min(dp[ca][cc + 1], dp[ca][cc] + 1)

            for p in problems:
                if ca >= p[0] and cc >= p[1]:
                    na, nc = min(max_alp, ca + p[2]), min(max_cop, cc + p[3])
                    dp[na][nc] = min(dp[na][nc], dp[ca][cc] + p[4])

    return dp[max_alp][max_cop]


alp = 10
cop = 10
problems = [[10, 15, 2, 1, 2], [20, 20, 3, 3, 4]]
print(solution(alp, cop, problems))
