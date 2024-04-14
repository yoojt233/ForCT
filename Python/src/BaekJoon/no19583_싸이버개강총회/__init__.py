import sys

input = sys.stdin.readline


def splitTime(data):
    return int(data[:2] + data[3:])


op, mid, ed = map(splitTime, input().rstrip().split())
enter, exit = set(), set()

while True:
    temp = input().rstrip()
    if temp == "": break

    chat, nickname = temp.split()
    time = splitTime(chat)

    if time <= op:
        enter.add(nickname)
    elif mid <= time <= ed:
        exit.add(nickname)

ans = 0
for person in enter:
    if person in exit: ans += 1

print(ans)
