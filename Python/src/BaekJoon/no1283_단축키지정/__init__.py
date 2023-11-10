import sys

input = sys.stdin.readline


def solve(words):
    for i in range(len(words)):
        key = ord(words[i][0].lower()) - ord('a')
        if short[key]: continue

        short[key] = True
        words[i] = "[" + words[i][0] + "]" + words[i][1:]
        print(" ".join(words))
        return

    for i in range(len(words)):
        word = words[i].lower()
        for cur in range(1, len(word)):
            key = ord(word[cur]) - ord('a')
            if short[key]: continue

            short[key] = True
            words[i] = words[i][:cur] + "[" + words[i][cur] + "]" + words[i][cur + 1:]
            print(" ".join(words))
            return

    print(" ".join(words))
    return


n = int(input())
short = [False] * 26
for _ in range(n):
    words = input().split()
    solve(words)
