import sys

input = sys.stdin.readline

n = int(input())
if n < 3:
    print(1)
elif n < 6:
    print(2)
else:
    print(3)

# Other easy code
# print(min(int(input()) // 3 + 1, 3))
