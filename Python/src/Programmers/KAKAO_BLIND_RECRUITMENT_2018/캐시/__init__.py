from collections import deque


def solution(cacheSize, cities):
    res = 0
    cache = deque(maxlen=cacheSize)

    for city in cities:
        city = city.lower()

        if city in cache:
            res += 1
            cache.remove(city)
        else:
            res += 5

        cache.append(city)

    return res


cacheSize = 0
cities = ["la", "la"]
print(solution(cacheSize, cities))
