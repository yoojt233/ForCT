def solution(n, left, right):
    u, d = (left // n) + 1, (right // n) + 1
    res = []

    for i in range(u, d + 1):
        for _ in range(i): res.append(i)
        for _ in range(n - i): res.append(res[-1] + 1)

    op = left % n
    return res[op:op + right - left + 1]


print(solution(n=4, left=7, right=14))
