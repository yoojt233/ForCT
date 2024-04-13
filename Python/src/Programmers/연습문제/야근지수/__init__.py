from heapq import heappush, heappop


def solution(n, works):
    temp = []
    for x in works: heappush(temp, -x)

    while temp and n > 0:
        next = heappop(temp) + 1
        if next < 0: heappush(temp, next)
        n -= 1

    return sum([x ** 2 for x in temp])


works = [1, 1]
n = 3
print(solution(n, works))
