import sys


def adv_input():
    return sys.stdin.readline().rstrip()


def est(op):
    idx = 2
    while op * idx < b + 1:
        isPrime[op * idx] = False
        idx += 1


def factorization(i) -> int:
    if dp[i] == 0:
        for p in primes:
            if i % p != 0: continue
            dp[i] = factorization(i // p) + factorization(p)
            break

    return dp[i]


a, b = map(int, adv_input().split())
isPrime = [True] * (b + 1)
primes = []

dp = [0] * (b + 1)
for i in range(2, int(b ** 0.5) + 1):
    if not isPrime[i]: continue
    est(i)

for i in range(2, b + 1):
    if isPrime[i]:
        dp[i] = 1
        primes.append(i)

ans = 0
for i in range(a, b + 1):
    if factorization(i) in primes: ans += 1
print(ans)
