import sys

input = sys.stdin.readline
print(*[i for i in range(int(input()), 0, -1)])
