import sys

input = sys.stdin.readline


def move(n, op, ed):
    if n == 0:
        return

    move(n - 1, op, 6 - op - ed)
    print(op, ed)
    move(n - 1, 6 - op - ed, ed)


n = int(input())
print(2 ** n - 1)
move(n, 1, 3)
