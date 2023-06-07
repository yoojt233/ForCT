import sys

input = sys.stdin.readline


def match(small, tall):
    cnt = 0
    s = len(small)
    t = len(tall)
    x = 0
    y = 0
    while x < s and y < t:
        if small[x] > tall[y]:
            cnt += 1
            x += 1
            y += 1
        else:
            x += 1
    return cnt


humans = [[[], []], [[], []]]
n = int(input())

for x in range(2):
    temp = list(map(int, input().split()))
    for i in temp:
        if i < 0:
            humans[x][0].append(abs(i))
        else:
            humans[x][1].append(i)
    humans[x][0].sort()
    humans[x][1].sort()

print(match(humans[0][0], humans[1][1]) + match(humans[1][0], humans[0][1]))
