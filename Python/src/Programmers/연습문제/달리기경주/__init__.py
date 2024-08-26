def solution(players, callings):
    dict = {key: i for i, key in enumerate(players)}

    for self in callings:
        idx = dict[self]
        other = players[idx - 1]

        dict[self] -= 1
        dict[other] += 1

        players[idx - 1], players[idx] = self, other

    return players


players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]

print(solution(players, callings))
