import sys


def adv_input():
    return sys.stdin.readline().rstrip()


N, x = map(int, adv_input().split())
limit = list(map(int, adv_input().split()))
plus = list(map(int, adv_input().split()))

w = 0
flag = True
for i in range(N):
    w += plus[i]
    if w < limit[i]:
        flag = False
        break


def health():
    return (w - limit[-1]) // x


print(-1 if not flag else health())
