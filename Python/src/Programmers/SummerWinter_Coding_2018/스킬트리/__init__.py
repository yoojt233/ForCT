def check(parent, tree):
    visited = [False for _ in range(26)]
    for c in tree:
        if c in parent.keys() and not visited[ord(parent[c]) - ord('A')]: return False
        visited[ord(c) - ord('A')] = True

    return True


def solution(skill, skill_trees):
    res = 0
    parent = {}

    for i in range(len(skill) - 1, 0, -1): parent[skill[i]] = skill[i - 1]

    for tree in skill_trees:
        if not check(parent, tree): continue
        res += 1
    return res


skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees))
