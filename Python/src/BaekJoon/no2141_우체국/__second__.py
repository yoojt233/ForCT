import sys

input = sys.stdin.readline

n = int(input().rstrip())
villages = []
total = 0

for _ in range(n):
    idx, people = map(int, input().rstrip().split())
    villages.append((idx, people))
    total += people

villages.sort(key=lambda x: x[0])
half = total / 2
cnt = 0
for i in range(n):
    cnt += villages[i][1]
    if cnt >= half:
        print(villages[i][0])
        break
