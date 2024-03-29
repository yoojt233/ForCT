import sys

input = sys.stdin.readline


class Number:
    def __init__(self):
        self.last = -1
        self.isLock = False

    def lock(self, pos):
        self.isLock = True
        self.last = pos

    def unlock(self):
        self.isLock = False


def solve(n, nums):
    res, left, right = 0, 0, 0
    temp = [Number() for _ in range(100001)]

    while right < n:
        cur = nums[right]

        if not temp[cur].isLock:
            temp[cur].lock(right)
            right += 1
            res += (right - left)
        else:
            for i in range(left, temp[cur].last + 1): temp[nums[i]].unlock()
            left = temp[cur].last + 1

    return res


n = int(input().rstrip())
nums = list(map(int, input().rstrip().split()))

print(solve(n, nums))
