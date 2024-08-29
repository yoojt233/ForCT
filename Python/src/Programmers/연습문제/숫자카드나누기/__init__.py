def solution(arrayA, arrayB):
    res = 0

    arrayA.sort()
    arrayB.sort()

    gcdA = arrayA[0]
    gcdB = arrayB[0]

    for x in arrayA[1:]: gcdA = gcd(x, gcdA)
    for x in arrayB[1:]: gcdB = gcd(x, gcdB)

    if check(gcdA, arrayB): res = max(res, gcdA)
    if check(gcdB, arrayA): res = max(res, gcdB)

    return res


def gcd(a, b):
    return b if a % b == 0 else gcd(b, a % b)


def check(x, arr):
    for i in arr:
        if i % x == 0: return False

    return True


print(solution(arrayA=[14, 35, 119], arrayB=[18, 30, 102]))
