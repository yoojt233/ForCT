import sys


def adv_input():
    return sys.stdin.readline().rstrip()


n = int(adv_input())
cheese = set([])
for item in adv_input().split():
    if item[-6:] == 'Cheese':
        cheese.add(item)

print('yummy' if len(cheese) >= 4 else 'sad')
