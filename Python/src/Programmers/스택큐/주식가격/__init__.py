def solution(prices):
    res = [0 for _ in range(len(prices))]
    stack = []

    for i in range(len(prices)):
        while stack and prices[stack[-1]] > prices[i]:
            idx = stack.pop()
            res[idx] = i - idx

        stack.append(i)

    while stack:
        idx = stack.pop()
        res[idx] = len(prices) - idx - 1

    return res


prices = [5, 4, 3, 2, 1]
print(solution(prices))
