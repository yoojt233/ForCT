import sys


def adv_input():
    return sys.stdin.readline()


N, l = map(int, adv_input().split())
fruits = sorted(list(map(int, adv_input().split())))
for f in fruits:
    if l < f:
        break
    l += 1
print(l)
