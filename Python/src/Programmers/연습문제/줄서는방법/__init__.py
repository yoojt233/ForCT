def solution(n, k):
    nums = [i for i in range(1, n + 1)]
    dp = [1]
    k -= 1
    ans = []

    for i in range(1, n + 1): dp.append(dp[-1] * i)

    while nums:
        temp = dp[len(nums) - 1]
        idx = 0

        while k >= temp:
            idx += 1
            k -= temp

        ans.append(nums.pop(idx))

    return ans


print(solution(n=3, k=5))
