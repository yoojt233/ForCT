import math


def solution(n, stations, w):
    res = 0
    left, right = 0, n

    for st in stations:
        right = st - w - 1
        res += math.ceil((right - left) / (w * 2 + 1))
        left = st + w

    if left < n:
        res += math.ceil((n - left) / (w * 2 + 1))

    return res


n = 16
stations = [9]
w = 2

print(solution(n, stations, w))
