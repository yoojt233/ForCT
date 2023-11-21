import sys

input = sys.stdin.readline

origin = input().rstrip()
length, a = len(origin), origin.count('a')
res = sys.maxsize

origin += origin[0:a - 1]

for i in range(length):
    res = min(res, origin[i:i + a].count('b'))

print(res)
