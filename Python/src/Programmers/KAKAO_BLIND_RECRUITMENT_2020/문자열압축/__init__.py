def solution(s):
    res = len(s)

    for i in range(1, (len(s) // 2) + 1):
        op, cnt = 0, 0
        first = s[op:op + i]
        temp = ""

        while op < len(s):
            cur = s[op:op + i]

            if first == cur:
                cnt += 1
            else:
                if cnt > 1: temp += str(cnt)
                temp += first
                cnt = 1
                first = cur

            op += i

        if cnt > 1: temp += str(cnt)
        temp += first

        res = min(res, len(temp))

    return res


s = "abcabcabcabcdededededede"
print(solution(s))
