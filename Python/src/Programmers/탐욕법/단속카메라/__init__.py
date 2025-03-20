def solution(routes):
    res = 0
    temp = -30001

    routes.sort(key=lambda x: x[1])
    for route in routes:
        if route[0] > temp:
            res += 1
            temp = route[1]

    return res


routes = [[-20, -15], [-14, -5], [-18, -13], [-5, -3], [3, 10]]
print(solution(routes))
