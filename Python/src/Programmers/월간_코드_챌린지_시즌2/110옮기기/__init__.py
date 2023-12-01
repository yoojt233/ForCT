from collections import deque


def solution(s):
    res = []
    for origin in s:
        res.append(solve(origin))
    return res


def solve(origin):
    dq, cnt = deque([]), 0

    for s in origin:
        if s == '0' and len(dq) >= 2 and dq[-1] == '1' and dq[-2] == '1':
            for _ in range(2): dq.pop()
            cnt += 1
        else:
            dq.append(s)

    temp = ''.join(dq)
    target = "110" * cnt
    fz = temp.rfind('0')

    return temp[:fz + 1] + target + temp[fz + 1:]


s = ["1110", "100111100", "0111111010"]
print(solution(s))
