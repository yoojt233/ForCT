def solution(beginning, target):
    compare = [[beginning[i][j] ^ target[i][j] for j in range(len(target[0]))] for i in range(len(target))]

    row = compare[0]
    cnt = sum(row)

    for i in range(1, len(beginning)):
        if row == compare[i]: continue
        if [1 - e for e in compare[i]] != row: return -1

        cnt += 1

    return min(cnt, len(beginning) + len(row) - cnt)


beginning = [[0, 1, 0, 0, 0], [1, 0, 1, 0, 1], [0, 1, 1, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 1, 0]]
target = [[0, 0, 0, 1, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]
