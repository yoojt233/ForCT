import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
ingredients = [list(map(int, input().rstrip().split())) for _ in range(n)]
ans = max(sum(ingredients[i][j] for i, j in combinations(combo, 2)) for combo in combinations(range(n), m))
print(ans)
