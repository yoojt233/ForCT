from itertools import combinations, product
from bisect import bisect_left


def solution(dice):
    ans = []
    temp = 0
    n = len(dice)

    for a_sel in list(combinations(range(n), n >> 1)):
        a_dice, b_dice = [], []

        for i in range(n):
            if i in a_sel:
                a_dice.append(dice[i])
            else:
                b_dice.append(dice[i])

        a_sum = [sum(a) for a in product(*a_dice)]
        b_sum = sorted([sum(b) for b in product(*b_dice)])

        cnt = sum(bisect_left(b_sum, a) for a in a_sum)

        if temp < cnt:
            ans = [i + 1 for i in a_sel]
            temp = cnt

    return ans


dice = [[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]
print(solution(dice))
