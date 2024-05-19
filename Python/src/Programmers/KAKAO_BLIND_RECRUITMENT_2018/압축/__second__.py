def solution(msg):
    res = []
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    dict = {k: v for (k, v) in zip(alpha, range(1, 27))}
    size = len(dict.keys())

    while True:
        if msg in dict:
            res.append(dict[msg])
            break

        for i in range(1, len(msg) + 1):
            cur = msg[0:i - 1]
            if cur + msg[i - 1] in dict: continue

            res.append(dict[cur])
            dict[cur + msg[i - 1]] = size + 1
            size += 1
            msg = msg[i - 1:]
            break

    return res


msg = "ABABABABABABABAB"
print(solution(msg))
