def solution(land):
    n = len(land)

    for r in range(1, n):
        for c in range(4):
            land[r][c] += max(land[r - 1][:c] + land[r - 1][c + 1:])

    return max(land[-1])


land = [[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]
print(solution(land))
