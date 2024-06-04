def solution(sequence):
    dp = [0]
    for i, v in enumerate(sequence): dp.append(dp[-1] + v * [1, -1][i % 2])

    return max(dp) - min(dp)


sequence = [2, 3, -6, 1, 3, -1, 2, 4]
print(solution(sequence))
