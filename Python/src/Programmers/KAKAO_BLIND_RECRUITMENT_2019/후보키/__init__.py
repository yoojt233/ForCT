from itertools import combinations


def solution(relation):
    row = len(relation)
    col = len(relation[0])

    combo = []
    for i in range(1, col + 1):
        combo.extend(combinations(range(col), i))

    candidate = []
    for c in combo:
        temp = [tuple(value[idx] for idx in c) for value in relation]
        if len(set(temp)) == row:
            candidate.append(c)

    res = set(candidate)
    for i in range(len(candidate)):
        for j in range(i + 1, len(candidate)):
            if len(candidate[i]) == len(set(candidate[i]).intersection(set(candidate[j]))):
                res.discard(candidate[j])

    return len(res)


relation = [["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
            ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]

print(solution(relation))
