def solution(n, words):
    already, last = set([words[0]]), words[0][-1]

    for i in range(1, len(words)):
        cur = words[i]

        if (cur in already) or (last != cur[0]): return [(i % n) + 1, (i // n) + 1]

        already.add(cur)
        last = cur[-1]

    return [0, 0]


n = 3
words = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]
print(solution(n, words))
