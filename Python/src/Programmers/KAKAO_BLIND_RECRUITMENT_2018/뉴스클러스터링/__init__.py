def separate(string):
    res = []

    for i in range(len(string) - 1):
        a, b = string[i], string[i + 1]
        if a in alphabet and b in alphabet: res.append(a.upper() + b.upper())

    return res


def solution(str1, str2):
    sep1, sep2 = separate(str1), separate(str2)
    intersection, union = 0, len(sep1)

    for elem in sep1:
        if elem in sep2:
            intersection += 1
            sep2.remove(elem)

    union += len(sep2)
    res = 65536

    return res * intersection // union if union > 0 else res


alphabet = [chr(i) for i in range(ord('a'), ord('z') + 1)]
for i in range(ord('A'), ord('Z') + 1): alphabet.append(chr(i))

str1 = "aa1+aa2"
str2 = "AAAA12"
print(solution(str1, str2))
