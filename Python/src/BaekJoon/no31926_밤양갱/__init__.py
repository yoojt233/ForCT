import math
import sys

input = sys.stdin.readline


def solve(n):
    return 8 if n == 1 else solve(math.floor(n / 2)) + 1


print(solve(int(input().rstrip())) + 2)
