import sys


def adv_input():
    return sys.stdin.readline()


hh, mm = map(int, adv_input().split())
mm += int(adv_input())

if mm >= 60:
    hh += (mm / 60)
    mm %= 60
hh %= 24

print("%d %d" % (hh, mm))
