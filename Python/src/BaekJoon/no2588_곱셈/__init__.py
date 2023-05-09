import sys


def adv_input():
    return sys.stdin.readline()


a = int(adv_input())
b = adv_input()

ans = []
for i in reversed(range(3)):
    ans.append(a * int(b[i]))

for i in range(len(ans)):
    print(ans[i])
    ans[i] *= pow(10, i)

print(sum(ans))
