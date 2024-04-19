def solution(people, limit):
    res, left, right = 0, 0, len(people) - 1
    people.sort()

    while left <= right:
        if left == right:
            res += 1
            break

        if people[left] + people[right] <= limit: left += 1
        right -= 1
        res += 1

    return res


people = [20, 30, 70, 90]
limit = 100

print(solution(people, limit))
