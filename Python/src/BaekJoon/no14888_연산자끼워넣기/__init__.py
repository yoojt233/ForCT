import sys

input = sys.stdin.readline


def solve(level, num):
    if level == n:
        ans.append(num)
        return

    for i in range(4):
        if operator[i] == 0: continue
        operator[i] -= 1
        if i == 0:
            solve(level + 1, num + nums[level])
        elif i == 1:
            solve(level + 1, num - nums[level])
        elif i == 2:
            solve(level + 1, num * nums[level])
        else:
            solve(level + 1, num // nums[level] if num >= 0 else -(-num // nums[level]))
        operator[i] += 1


ans = []
n = int(input().rstrip())
nums = list(map(int, input().rstrip().split()))
operator = list(map(int, input().rstrip().split()))

solve(1, nums[0])
print(max(ans))
print(min(ans))

# 다른 풀이. max와 min값을 정해둔 후, 최대 level에서 갱신.
# INF = sys.maxsize
# ans = [-INF, INF]
# ans[0] = max(ans[0], num)
# ans[1] = min(ans[1], num)