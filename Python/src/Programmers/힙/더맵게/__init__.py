import heapq


def solution(scoville, K):
    res = 0
    heapq.heapify(scoville)

    while len(scoville) >= 2:
        a = heapq.heappop(scoville)
        if a >= K:
            heapq.heappush(scoville, a)
            break

        b = heapq.heappop(scoville)
        heapq.heappush(scoville, a + b * 2)
        res += 1

    if scoville and heapq.heappop(scoville) >= K:
        return res
    else:
        return -1


scoville = [9, 1, 2, 3, 12, 10]
K = 7
print(solution(scoville, K))
