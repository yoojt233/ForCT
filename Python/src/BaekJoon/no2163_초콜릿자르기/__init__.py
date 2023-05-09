import sys


def adv_input():
    return sys.stdin.readline().split(" ")


a, b = adv_input()
print(int(a) * int(b) - 1)
