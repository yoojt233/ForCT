import sys
from collections import deque

input = sys.stdin.readline
nums = deque([i + 1 for i in range(int(input()))])
nums.rotate()
print(*nums)