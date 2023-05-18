import sys


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
origin = adv_input()
bracket = {'(': n // 2, ')': n // 2}
for c in origin:
    if c == '(':
        bracket[c] -= 1
    elif c == ')':
        bracket[c] -= 1

origin = origin.replace('G', '(', bracket['(']).replace('G', ')', bracket[')'])
print(origin)
