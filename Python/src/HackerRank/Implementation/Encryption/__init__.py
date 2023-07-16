import math


def encryption(s):
    l = math.sqrt(len(s))
    column = math.ceil(l)
    row = math.ceil(len(s) / column)

    enc = []
    for i in range(row):
        enc.append(s[i * column:(i + 1) * column])

    res = ""
    for j in range(column):
        for i in range(row):
            if len(enc[i]) > j: res += enc[i][j]
        res += " "

    return res


if __name__ == '__main__':
    s = input()

    result = encryption(s.strip())

    print(result)
