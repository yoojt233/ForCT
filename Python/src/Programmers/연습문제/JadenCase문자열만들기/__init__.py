def solution(s):
    res = ""
    temp = ""
    for i in range(len(s)):
        if s[i] != " ":
            temp += s[i]
            continue
        res += (temp.capitalize() + s[i])
        temp = ""
    res += temp.capitalize()
    return res


# string.title() 메소드는 문자열의 시작이 숫자일 경우, 다음에 오는 알파벳을 대문자로 치환하기 때문에 불가능.
s = "3people unFollowed me"
print(solution(s))
