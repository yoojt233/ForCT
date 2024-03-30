import sys

input = sys.stdin.readline


def solve(n, l, w, h):
    left, right = 0, max(l, w, h)

    for _ in range(100):
        mid = (left + right) / 2
        cnt = (l // mid) * (w // mid) * (h // mid)

        if cnt >= n:
            left = mid
        else:
            right = mid

    return left


n, l, w, h = map(int, input().rstrip().split())
print(solve(n, l, w, h))
