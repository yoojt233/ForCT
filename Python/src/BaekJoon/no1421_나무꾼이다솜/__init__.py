import sys


def adv_input():
    return sys.stdin.readline().rstrip()


N, C, W = map(int, adv_input().split())
woods = {}
for _ in range(N):
    wood = int(adv_input())
    woods[wood] = woods.get(wood, 0) + 1

ans = 0
for i in range(max(woods.keys())):
    money = 0
    for wood in woods:
        if wood < (i + 1): continue
        piece, remain = divmod(wood, (i + 1))

        used = piece * C
        if remain == 0: used -= C

        sell = (piece * (i + 1) * W) - used
        if sell > 0: money += (sell * woods[wood])

    ans = max(ans, money)
print(ans)
