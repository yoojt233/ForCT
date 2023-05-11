import sys


def adv_input():
    return sys.stdin.readline()


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


ans = []
for t in range(int(adv_input())):
    a, b = map(int, adv_input().split())
    print(a * b // gcd(a, b))
