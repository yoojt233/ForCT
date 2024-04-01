def calc(minerals):
    temp = [0, 0, 0]

    for mineral in minerals:
        if mineral == "diamond":
            temp[0] += 1
        elif mineral == "iron":
            temp[1] += 1
        else:
            temp[2] += 1

    return [len(minerals), 5 * temp[0] + temp[1] + temp[2], 25 * temp[0] + 5 * temp[1] + temp[2]]


def solution(picks, minerals):
    remain_picks = sum(picks)
    temp, res = [], 0

    for i in range(remain_picks): temp.append(calc(minerals[i * 5: i * 5 + 5]))
    temp.sort(key=lambda x: (x[2], x[1]), reverse=True)

    for five in temp:
        for i in range(3):
            if picks[i] <= 0: continue
            picks[i] -= 1
            res += five[i]
            break

    return res


picks = [0, 0, 1]
minerals = ["stone", "stone", "stone", "stone", "stone", "diamond"]
print(solution(picks, minerals))
