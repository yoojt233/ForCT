import sys
import bisect


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
choco = [1]
limit = 0
while choco[-1] < n:
    choco.append(choco[-1] * 2)
    limit += 1

cut = 0
while n > 0:
    piece = bisect.bisect_left(choco, n)
    if n != choco[piece]: piece -= 1
    n -= choco[piece]
    cut = (limit - piece)

print(choco[-1], end=" ")
print(cut)
