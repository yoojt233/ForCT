def solution(numbers):
    res = []

    for num in numbers:
        flag = False
        temp = list(bin(num)[2:][::-1])

        for i in range(len(temp)):
            if temp[i] == '1':
                last = i
                continue

            flag = True
            temp[i] = '1'

            if i > 0: temp[i - 1] = '0'

            break

        if not flag:
            temp[-1] = '0'
            temp.append('1')

        res.append(int(''.join(temp[::-1]), 2))

    return res


print(solution(numbers=[2, 7]))
