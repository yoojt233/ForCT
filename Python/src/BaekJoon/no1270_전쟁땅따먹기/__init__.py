import sys


def adv_input():
    return sys.stdin.readline().rstrip()


for t in range(int(adv_input())):
    temp = adv_input().split()
    n = int(temp.pop(0))
    soldier = {}

    ans = ""
    value = 0
    for i in range(n):
        key = temp[i]
        soldier[key] = soldier.get(key, 0) + 1

        if soldier[key] > value:
            ans = key
            value = soldier[key]

    if value > n / 2:
        print(ans)
    else:
        print("SYJKGW")
