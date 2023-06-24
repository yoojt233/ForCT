import sys

input = sys.stdin.readline

x = input().rstrip()
l = len(x)
for i in range(l):
    temp = x[i:]
    if temp == temp[::-1]:
        print(l + i)
        break
