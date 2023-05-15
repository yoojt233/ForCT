import sys
from collections import Counter


def adv_input():
    return sys.stdin.readline().rstrip()


for t in range(int(adv_input())):
    temp = adv_input().split()
    n = int(temp.pop(0))
    cnt = Counter(temp)
    ans = "SYJKGW"
    for k, v in cnt.items():
        if v > n / 2:
            ans = k
            break
    print(ans)
