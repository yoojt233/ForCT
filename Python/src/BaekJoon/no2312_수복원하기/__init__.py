import sys

input = sys.stdin.readline


def eratos(x):
    global nums, limit

    i = x * 2
    while i < limit:
        nums[i] = True
        i += x


def solve(op, n, dict):
    if n == 1: return

    for i in range(op, len(primes)):
        num = primes[i]

        if n % num != 0: continue

        if num in dict.keys():
            dict[num] += 1
        else:
            dict[num] = 1

        solve(i, n // primes[i], dict)
        break


limit = 100001
nums = [False for i in range(limit)]
primes = []

for i in range(2, limit):
    if not nums[i]:
        primes.append(i)
        eratos(i)

for _ in range(int(input().rstrip())):
    dict = {}
    solve(0, int(input().rstrip()), dict)
    for i in dict.keys():
        print(f'{i} {dict[i]}')

