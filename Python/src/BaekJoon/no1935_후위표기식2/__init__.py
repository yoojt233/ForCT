import sys
from collections import deque

input = sys.stdin.readline


def calc(a, b, oper):
    if oper == "+":
        return b + a
    elif oper == "-":
        return b - a
    elif oper == "*":
        return b * a
    else:
        return b / a


n = int(input().rstrip())
expression = input().rstrip()
dic = {}

op = ord("A")
for _ in range(n):
    value = int(input().rstrip())
    dic[chr(op)] = value
    op += 1

numbers = deque([])
for x in expression:
    if ord(x) in range(ord("A"), ord("Z") + 1):
        numbers.append(dic[x])
    else:
        numbers.append(calc(numbers.pop(), numbers.pop(), x))

print(format(numbers.pop(), ".2f"))
