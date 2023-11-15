import sys

input = sys.stdin.readline


def solve(original):
    length = len(original)
    if length == 1: return True

    mid = length // 2
    left, right = original[0:mid], original[mid + 1:length][::-1]

    for i in range(mid):
        if left[i] + right[i] == 1: continue
        return False

    return solve(left)


for t in range(int(input().rstrip())):
    print("YES" if solve(list(map(int, input().rstrip()))) else "NO")
