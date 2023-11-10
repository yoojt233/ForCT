board = [
    [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
    [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
    [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
    [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
]


def solve(s, x):
    res = 0
    for i in range(3):
        for j in range(3):
            res += abs(x[i][j] - s[i][j])

    return res


def formingMagicSquare(s):
    ans = 90
    for arr in board:
        temp = []
        for line in arr:
            temp.append(line[::-1])
        ans = min(solve(s, temp), solve(s, arr), ans)
    return ans


if __name__ == '__main__':
    s = []

    for _ in range(3):
        s.append(list(map(int, input().rstrip().split())))

    result = formingMagicSquare(s)
    print(result)
