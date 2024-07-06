def solution(triangle):
    for level in range(1, len(triangle)):
        for i in range(level + 1):
            if i == 0:
                triangle[level][i] += triangle[level - 1][i]
            elif i == level:
                triangle[level][i] += triangle[level - 1][i - 1]
            else:
                triangle[level][i] += max(triangle[level - 1][i - 1], triangle[level - 1][i])

    return max(triangle[-1])


print(solution(triangle=[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))
