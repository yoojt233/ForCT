def s_i(arr, x):
    res = 0

    for i in range(len(arr)): res += (arr[i] % x)

    return res


def solution(data, col, row_begin, row_end):
    data.sort(key=lambda x: (x[col - 1], -x[0]))

    res = s_i(data[row_begin - 1], row_begin)

    for i in range(row_begin, row_end): res ^= s_i(data[i], i + 1)

    return res


data = [[2, 2, 6], [1, 5, 10], [4, 2, 9], [3, 8, 3]]
col = 2
row_begin = 2
row_end = 3

print(solution(data, col, row_begin, row_end))
