def solution(s):
    res = [0, 0]
    while s != '1':
        res[0] += 1
        cnt = s.count('1')
        res[1] += (len(s) - cnt)
        s = format(cnt, 'b')
    return res


s = "110010101001"
print(solution(s))
