def solution(n):
    num = ['1', '2', '4']
    temp = ''

    while n > 0:
        n, r = divmod(n - 1, 3)
        temp += num[r]

    return temp[::-1]


n = [1, 2, 3, 4]
print(list(map(solution, n)))
