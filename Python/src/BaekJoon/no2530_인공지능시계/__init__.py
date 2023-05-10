import sys


def adv_input():
    return sys.stdin.readline()


hh, mm, ss = map(int, adv_input().split())
ss += int(adv_input())

if ss >= 60:
    mm += (ss / 60)
    ss %= 60

if mm >= 60:
    hh += (mm / 60)
    mm %= 60

hh %= 24

print("%d %d %d" % (hh, mm, ss))
