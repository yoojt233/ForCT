import sys


def adv_input():
    return sys.stdin.readline()


class univ:
    name = ""
    alcohol = 0


for t in range(int(adv_input())):
    n = int(adv_input())
    ans = univ()
    for i in range(n):
        temp = adv_input().split()
        if int(temp[1]) > ans.alcohol:
            ans.name = temp[0]
            ans.alcohol = int(temp[1])
    print(ans.name)
