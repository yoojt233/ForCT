def solution(n):
    res = 1

    while n > 1:
        if n % 2 == 1: res += 1
        n //= 2

    return res


n = 5000
print(solution(n))
