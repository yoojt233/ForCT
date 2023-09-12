import sys

input = sys.stdin.readline

s = input().rstrip()
zero, one = s.count('0'), s.count('1')

for _ in range(zero // 2):
    idx = s.rfind('0')
    s = s[:idx] + s[idx + 1:]
print(s.replace('1', '', one // 2))
