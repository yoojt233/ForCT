import sys


def adv_input():
    return sys.stdin.readline()


for i in range(int(adv_input())):
    a, b = adv_input().split(" ")
    print("Case #%d: %d" % (i + 1, int(a) + int(b)))
