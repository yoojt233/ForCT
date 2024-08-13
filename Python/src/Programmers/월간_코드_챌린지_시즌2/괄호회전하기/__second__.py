from collections import deque

flag = False


def solution(s):
    if len(s) % 2 != 0: return 0

    res = 0
    cur = deque(map(convert, list(s)))

    for _ in range(len(s)):
        temp = check(cur)

        if flag:
            res = temp
            break

        cur.rotate()

    return res


def convert(x):
    if x == '[':
        return 1
    elif x == '{':
        return 2
    elif x == '(':
        return 3
    elif x == ']':
        return -1
    elif x == '}':
        return -2
    else:
        return -3


def check(dq):
    global flag

    res = 0
    q = deque([])

    for i in range(len(dq)):
        cur = dq[i]

        if cur < 0:
            if len(q) == 0:
                return 0
            else:
                if q[-1] == -cur:
                    q.pop()
                else:
                    return 0

            if len(q) == 0:  res += 1

        else:
            q.append(cur)

    if len(q) == 0:
        flag = True
        return res
    else:
        return 0


print(solution(s="[)(]"))
