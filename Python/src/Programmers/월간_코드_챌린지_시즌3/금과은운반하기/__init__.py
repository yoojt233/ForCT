def solution(a, b, g, s, w, t):
    op, ed = 0, (10 ** 9) * (10 ** 5) * 4
    n, res = len(g), (10 ** 9) * (10 ** 5) * 4

    while op <= ed:
        mid = (op + ed) // 2
        Au, Ag, total = 0, 0, 0

        for i in range(n):
            move = mid // (t[i] * 2)
            if mid % (t[i] * 2) >= t[i]: move += 1
            amount = move * w[i]

            Au += min(g[i], amount)
            Ag += min(s[i], amount)
            total += min(g[i] + s[i], amount)

        if Au >= a and Ag >= b and total >= a + b:
            ed = mid - 1
            res = min(res, mid)
        else:
            op = mid + 1

    return res


a = 90
b = 500
g = [70, 70, 0]
s = [0, 0, 500]
w = [100, 100, 2]
t = [4, 8, 1]
print(solution(a, b, g, s, w, t))
