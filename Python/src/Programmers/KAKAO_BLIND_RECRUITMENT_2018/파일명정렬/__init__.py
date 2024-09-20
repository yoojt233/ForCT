def slicing(file):
    res = ["", "", ""]
    idx = 0
    flag = 0

    for i in range(1, len(file)):
        if flag == 0 and file[i].isdecimal():
            res[flag] = file[:i]
            flag += 1
            idx = i
        elif flag == 1 and not file[i].isdecimal():
            res[flag] = file[idx:i]
            res[2] = file[i:]
            break

    if res[1] == "":
        res[1] = file[idx:]

    return res


def solution(files):
    files = list(map(slicing, files))
    files.sort(key=lambda x: (x[0].lower(), int(x[1])))

    return list(map(''.join, files))


print(solution(files=["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))
