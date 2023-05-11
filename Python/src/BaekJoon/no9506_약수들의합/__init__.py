import sys
import math


def adv_input():
    return sys.stdin.readline()


n = int(adv_input())
while n != -1:
    divisor = [1]
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            divisor.append(i)
            divisor.append(n // i)

    if sum(divisor) == n:
        print("%d =" % n, end=" ")
        divisor.sort()
        print(*divisor, sep=" + ")
    else:
        print("%d is NOT perfect." % n)

    n = int(adv_input())
