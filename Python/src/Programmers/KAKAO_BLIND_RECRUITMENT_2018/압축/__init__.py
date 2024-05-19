from collections import deque


def solution(msg):
    res = []
    dict = {chr(i).upper(): i - ord('A') + 1 for i in range(ord('A'), ord('Z') + 1)}
    size = len(dict.keys())

    cur = ''
    q = deque(list(msg))
    flag = True

    while q:
        while cur == '' or cur in dict.keys():
            if not q:
                flag = False
                break

            cur += q.popleft()

        if not flag: break

        res.append(dict[cur[:len(cur) - 1]])
        dict[cur] = size + 1
        size += 1

        cur = cur[-1]

    res.append(dict[cur])

    return res


msg = "ABABABABABABABAB"
print(solution(msg))
