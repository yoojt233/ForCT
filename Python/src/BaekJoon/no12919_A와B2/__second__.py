import sys

input = sys.stdin.readline


def solve(cur, level):
    if level == limit:
        return cur == target

    if cur[0] == 'B' and solve(cur[1:][::-1], level + 1):
        return True
    if cur[-1] == 'A' and solve(cur[:-1], level + 1):
        return True


target = input().rstrip()
s = input().rstrip()
limit = len(s) - len(target)
print(1 if solve(s, 0) else 0)
