def solution(m, n, board):
    res = 0
    temp = [list(x) for x in board]

    while True:
        lu = []

        find(m, n, temp, lu)
        if len(lu) == 0: break

        res += boom(temp, lu)
        drop(m, n, temp)

    return res


def find(m, n, temp, lu):
    for i in range(m - 1):
        for j in range(n - 1):
            if temp[i][j] == "": continue
            if temp[i][j] == temp[i + 1][j] == temp[i][j + 1] == temp[i + 1][j + 1]: lu.append((i, j))


def boom(temp, lu):
    res = 0

    for i, j in lu:
        if temp[i][j] != "":
            temp[i][j] = ""
            res += 1

        if temp[i + 1][j] != "":
            temp[i + 1][j] = ""
            res += 1

        if temp[i][j + 1] != "":
            temp[i][j + 1] = ""
            res += 1

        if temp[i + 1][j + 1] != "":
            temp[i + 1][j + 1] = ""
            res += 1

    return res


def drop(m, n, temp):
    for j in range(n):
        bottom = m

        for i in reversed(range(m)):
            if temp[i][j] == "":
                if bottom == m: bottom = i
                continue

            if bottom == m: continue

            temp[bottom][j] = temp[i][j]
            temp[i][j] = ""
            bottom -= 1


print(solution(m=6, n=6, board=["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))
