import copy
import sys

input = sys.stdin.readline


def count(s):
    res = {}
    for c in s:
        res[c] = res.get(c, 0) + 1
    return res


def solve(temp):
    org = copy.deepcopy(origin)
    change = True
    for c in temp:
        if c in org.keys():
            org[c] -= 1
        elif change:
            change = False
        else:
            return False

    check = True
    for i in org.values():
        if abs(i) > 1:
            return False
        elif abs(i) == 1:
            if check:
                check = False
            elif change:
                change = False
            else:
                return False

    return True


n = int(input().rstrip())
standard = input().rstrip()
origin = count(standard)

ans = 0
for _ in range(n - 1):
    temp = input().rstrip()
    if abs(len(temp) - len(standard)) > 1:
        continue
    elif solve(temp):
        ans += 1

print(ans)
