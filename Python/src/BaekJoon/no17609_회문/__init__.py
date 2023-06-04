import sys


def adv_input():
    return sys.stdin.readline().rstrip()


def isPalin(x, op, ed):
    while op <= ed:
        if x[op] != x[ed]:
            global chance
            if chance:
                chance = False
                return isPalin(x, op + 1, ed) or isPalin(x, op, ed - 1)
            else:
                return False

        op += 1
        ed -= 1
    return True


n = int(adv_input())
for _ in range(n):
    chance = True
    temp = adv_input()
    res = isPalin(temp, 0, len(temp) - 1)
    if res:
        if chance:
            print(0)
        else:
            print(1)
    else:
        print(2)
