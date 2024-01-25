import heapq


def solution(operations):
    q = []

    for operation in operations:
        o, num = operation.split()

        if o == "I":
            heapq.heappush(q, int(num))
        else:
            if not q: continue
            if num == "-1":
                heapq.heappop(q)
            else:
                q = heapq.nsmallest(len(q) - 1, q)

    smallest = 0 if not q else q[0]
    largest = 0 if not q else heapq.nlargest(1, q)[0]
    return [largest, smallest]


operations = ["I 1", "I 3", "I 5", "I 7", "I 9", "D -1", "D -1", "D 1", "I 2", "D 1", "D 1"]
print(solution(operations))
