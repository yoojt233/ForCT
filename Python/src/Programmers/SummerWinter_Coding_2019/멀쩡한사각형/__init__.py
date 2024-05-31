import math


def solution(w, h):
    return w * h - (w + h - math.gcd(w, h))


w, h = 8, 12
print(solution(w, h))
