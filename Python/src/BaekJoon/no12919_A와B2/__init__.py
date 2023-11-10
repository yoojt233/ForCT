import sys

input = sys.stdin.readline


def solve(cur, target, level):
    global flag
    if flag: return

    if level == limit:
        flag = (cur == target)
        return

    l = len(cur)
    if cur[-1] == 'B':
        if cur[0] != 'B':
            return
        temp = cur[1:]
        solve(temp[::-1], target, level + 1)
    else:
        if cur[0] == 'B':
            temp = cur[1:]
            solve(temp[::-1], target, level + 1)
        solve(cur[:l - 1], target, level + 1)


target = input().rstrip()
s = input().rstrip()
limit = len(s) - len(target)
flag = False

solve(s, target, 0)
print(1 if flag else 0)