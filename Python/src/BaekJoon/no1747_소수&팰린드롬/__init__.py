import math
import sys


def adv_input():
    return sys.stdin.readline().rstrip()


limit = 1003001
isPrime = [True for _ in range(limit + 1)]
palinPrime = []


def est():
    for i in range(2, int(math.sqrt(limit))):
        if not isPrime[i]: continue

        idx = 2
        while i * idx <= limit:
            isPrime[i * idx] = False
            idx += 1


def isPalin(x) -> bool:
    num = str(x)
    for i in range(0, len(num) // 2):
        if num[i] != num[len(num) - i - 1]: return False
    return True


est()
for i in range(2, limit + 1):
    if not isPrime[i]: continue
    if isPalin(i): palinPrime.append(i)

n = int(adv_input())
for x in palinPrime:
    if x < n: continue
    print(x)
    break
