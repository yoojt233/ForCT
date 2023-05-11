import sys


def adv_input():
    return sys.stdin.readline()


survey = {0: 0, 1: 0}
for i in range(int(adv_input())):
    n = int(adv_input())
    survey[n] = survey[n] + 1

if survey[0] > survey[1]:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")
