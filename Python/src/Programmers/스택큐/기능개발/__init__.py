from collections import deque


def solution(progresses, speeds):
    res = []
    dq = deque(progresses)
    last = len(progresses)
    offset = 0

    while True:
        if not dq: break
        for i in range(offset, last):
            dq.append(dq.popleft() + speeds[i])
        if dq[0] >= 100:
            temp = 0
            while dq and dq[0] >= 100:
                temp += 1
                dq.popleft()
            res.append(temp)
            offset += temp

    return res


progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]

print(solution(progresses, speeds))
