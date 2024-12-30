import sys

input = sys.stdin.readline


class Paper:
    def __init__(self, data):
        temp = list(data.split())
        self.name = temp[0]
        self.negative = []

        for i in range(1, len(temp)):
            if temp[i] == "N": self.negative.append(i)


tc = 1

while True:
    n = int(input().rstrip())
    if n == 0: break

    total = 0
    people = [Paper(input().rstrip()) for _ in range(n)]

    print(f'Group {tc}')
    tc += 1

    for i in range(n):
        if not people[i].negative:
            continue
        else:
            total += len(people[i].negative)

        for diff in people[i].negative:
            bad = (i + (n - diff)) % n
            print(f'{people[bad].name} was nasty about {people[i].name}')

    if total == 0: print("Nobody was nasty")
    print()
