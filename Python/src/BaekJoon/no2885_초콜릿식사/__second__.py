import sys


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
choco = [1]
while choco[-1] < n:
    choco.append(choco[-1] * 2)
print(choco[-1], end=" ")

cut = 0
while n > 0:
    temp = choco.pop()
    if n > temp: n -= temp
    elif n == temp: break
    cut += 1

print(cut)
