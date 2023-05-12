import sys


def adv_input():
    return sys.stdin.readline()


temp = adv_input().rstrip()
cnt = {"0": 0, "1": 0}
for i in range(len(temp)):
    if i == 0 or temp[i] != temp[i - 1]:
        cnt[temp[i]] += 1
    else:
        continue

print(min(cnt.values()))
