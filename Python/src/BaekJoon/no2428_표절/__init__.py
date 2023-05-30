import sys


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
files = list(map(int, adv_input().split()))
files.sort()

ans = 0
for i in range(n - 1):
    op, ed = i + 1, n - 1
    while op <= ed:
        mid = (op + ed) // 2
        if files[i] < files[mid] * 0.9:
            ed = mid - 1
        else:
            op = mid + 1
    ans += ed - i
print(ans)
