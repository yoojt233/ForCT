from collections import Counter


def solution(weights):
    people = Counter(weights)

    res = 0
    for k, v in people.items():
        if v >= 2: res += (v * (v - 1)) // 2

    weights = set(weights)
    for w in weights:
        for partner in (w * 2 / 3, w * 2 / 4, w * 3 / 4):
            if partner in weights: res += (people[w] * people[partner])

    return res


weights = [100, 180, 360, 100, 270]
print(solution(weights))
