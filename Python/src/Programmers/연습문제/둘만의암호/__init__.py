def solution(s, skip, index):
    ascii = [chr(i) for i in range(ord('a'), ord('z') + 1)]

    for c in skip: ascii.remove(c)
    l = len(ascii)

    return ''.join(ascii[(ascii.index(c) + index) % l] for c in s)


s = "aukks"
skip = "wbqd"
index = 5

print(solution(s, skip, index))
