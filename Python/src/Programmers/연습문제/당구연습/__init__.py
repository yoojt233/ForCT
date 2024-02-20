def calc(m, n, startX, startY, point):
    chance, dist = 1e9, 0

    if not (startX == point[0] and startY < point[1]):
        dist = (startX - point[0]) ** 2 + (2 * n - startY - point[1]) ** 2
        chance = min(chance, dist)

    if not (startX == point[0] and startY > point[1]):
        dist = (startX - point[0]) ** 2 + (startY + point[1]) ** 2
        chance = min(chance, dist)

    if not (startY == point[1] and startX > point[0]):
        dist = (startY - point[1]) ** 2 + (startX + point[0]) ** 2
        chance = min(chance, dist)

    if not (startY == point[1] and startX < point[0]):
        dist = (startY - point[1]) ** 2 + (2 * m - startX - point[0]) ** 2
        chance = min(chance, dist)

    return chance


def solution(m, n, startX, startY, balls):
    res = []

    for point in balls:
        res.append(calc(m, n, startX, startY, point))
    return res


m, n = 10, 10
startX, startY = 3, 7
balls = [[7, 7], [2, 7], [7, 3]]

print(solution(m, n, startX, startY, balls))
