import sys


def adv_input():
    return sys.stdin.readline()


def calc(num, operator):
    if operator == '@':
        num *= 3
    elif operator == '%':
        num += 5
    elif operator == '#':
        num -= 7
    return num


for i in range(int(adv_input())):
    temp = adv_input().split()
    num = float(temp[0])
    for j in range(1, len(temp)):
        num = calc(num, temp[j])
    print(format(num, ".2f"))
