import sys

input = sys.stdin.readline

board = []
n, m, b = map(int, input().rstrip().split())
for _ in range(n): board.extend(map(int, input().rstrip().split()))

time, height = sum(board) * 2, 0

for h in range(1, 257):
    put, take = 0, 0

    for tile in board:
        if tile > h:
            take += (tile - h)
        else:
            put += (h - tile)

    if put > take + b: continue
    if put + take * 2 <= time:
        time = put + take * 2
        height = h

print(time, height)
