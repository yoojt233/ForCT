import sys

input = sys.stdin.readline


def solve(n):
    if n not in dict: [n] = solve(n // p) + solve(n // q)

    return dict[n]


n, p, q = map(int, input().rstrip().split())
dict = {0: 1}

print(solve(n))
