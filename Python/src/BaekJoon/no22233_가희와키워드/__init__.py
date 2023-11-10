import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
keyword = set([])
for _ in range(n):
    keyword.add(input().rstrip())

for _ in range(m):
    keys = input().rstrip().split(',')
    for key in keys: keyword.discard(key)
    print(len(keyword))
