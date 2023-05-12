import sys


def adv_input():
    return sys.stdin.readline()


n = adv_input()
temp = adv_input()
a = temp.count("A")
b = temp.count("B")

if a == b:
    print("Tie")
elif a > b:
    print("A")
else:
    print("B")
