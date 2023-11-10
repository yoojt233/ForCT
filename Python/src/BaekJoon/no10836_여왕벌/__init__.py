import sys


def adv_input():
    return sys.stdin.readline().rstrip()


m, n = map(int, adv_input().split())
board = [[1 for _ in range(m)] for _ in range(m)]
grow = [1 for _ in range(2 * m - 1)]
for _ in range(n):
    zero, one, two = map(int, adv_input().split())
    for i in range(zero, zero + one): grow[i] += 1
    for i in range(zero + one, 2 * m - 1): grow[i] += 2

for i in range(m):
    for j in range(m):
        if j == 0:
            print(grow[m - i - 1], end=" ")
        else:
            print(grow[m + j - 1], end=" ")
    print()
