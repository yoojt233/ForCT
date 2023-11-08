from itertools import permutations


def solution(k, dungeons):
    res, n = 0, len(dungeons)
    for procedure in permutations(dungeons, n):
        remain, temp = k, 0
        for need, cost in procedure:
            if remain < need: break
            remain -= cost
            temp += 1
        res = max(res, temp)
    return res


k = 80
dungeons = [[80, 20], [50, 40], [30, 10]]
print(solution(k, dungeons))
