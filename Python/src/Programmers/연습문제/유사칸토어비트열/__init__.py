def divide(n, ed):
    if n == 1: return "11011"[:ed].count("1")

    res = 4 ** (n - 1)
    quote, remain = divmod(ed, 5 ** (n - 1))

    if quote < 2:
        res = res * quote + divide(n - 1, remain)
    elif quote == 2:
        res *= 2
    else:
        res = res * (quote - 1) + divide(n - 1, remain)

    return res


def solution(n, l, r):
    ans = divide(n, r) - divide(n, l - 1)
    return ans


n, l, r = 2, 4, 17
print(solution(n, l, r))
