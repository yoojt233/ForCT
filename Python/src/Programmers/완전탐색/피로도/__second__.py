res = 0
n = 0


def solution(k, dungeons):
    global n
    n = len(dungeons)
    permu(0, k, dungeons, [False for _ in range(n)])
    return res


def permu(level, remain, dungeons, visited):
    global res
    res = max(res, level)

    for i in range(n):
        if visited[i] or remain < dungeons[i][0]: continue
        visited[i] = True
        permu(level + 1, remain - dungeons[i][1], dungeons, visited)
        visited[i] = False


k = 80
dungeons = [[80, 20], [50, 40], [30, 10]]
print(solution(k, dungeons))
