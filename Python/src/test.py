def trans(x):
    for digit in "0123456789":
        x = x.replace(digit, '*')
    return x


def solution(code):
    res = []
    for c in code: res.append(trans(c))

    return len(code) - len(res)

code = ["A01", "A22", "A23", "43A", "BB1", "BB2"]
print(solution(code))
