def solution(sequence):
    dp = [[0], [0]]

    for i in range(len(sequence)):
        cur = sequence[i] if i % 2 == 0 else -sequence[i]

        dp[0].append(max(dp[0][-1] + cur, cur))
        dp[1].append(max(dp[1][-1] - cur, -cur))

    return max(max(dp[0]), max(dp[1]))


sequence = [2, 3, -6, 1, 3, -1, 2, 4]
print(solution(sequence))
