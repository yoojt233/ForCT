import sys

input = sys.stdin.readline

n = int(input().rstrip())
nums = list(map(int, input().rstrip().split()))

zero, one = nums.count(0), nums.count(1)

print(zero * one * 2 + zero * (n - zero - one) + zero * (zero - 1) // 2)
