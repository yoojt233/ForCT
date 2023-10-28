import sys

input = sys.stdin.readline

n = int(input().rstrip())
nums = sorted(list(map(int, input().rstrip().split())))
x = int(input().rstrip())
ans, left, right = 0, 0, n - 1

while left < right:
    temp = nums[left] + nums[right]
    if temp < x:
        left += 1
    else:
        if temp == x: ans += 1
        right -= 1
print(ans)
