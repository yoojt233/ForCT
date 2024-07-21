def solution(n, left, right):
    res = []

    for i in range(left, right + 1):
        res.append(max(i // n, i % n) + 1)

    return res


print(solution(n=3, left=2, right=5))
