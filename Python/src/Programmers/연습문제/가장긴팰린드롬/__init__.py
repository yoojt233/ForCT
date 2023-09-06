import sys

input = sys.stdin.readline


def solution(s):
    length = len(s)
    if s == s[::-1]:
        return length

    def isPalin(left, right):
        res = 0
        while left >= 0 and right < len(s) and s[left] == s[right]:
            res = right - left + 1
            left -= 1
            right += 1

        return res

    ans = 1
    for i in range(1, length - 1):
        ans = max(ans, isPalin(i - 1, i + 1), isPalin(i, i + 1))
    return ans


print(solution(input().rstrip()))
