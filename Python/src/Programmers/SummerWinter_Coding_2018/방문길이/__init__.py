def solution(dirs):
    dxdy = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}
    rows = [[False] * 10 for _ in range(11)]
    cols = [[False] * 11 for _ in range(10)]
    cur = [5, 5]
    cnt = 0

    for d in dirs:
        nr = cur[0] + dxdy[d][0]
        nc = cur[1] + dxdy[d][1]

        if nr not in range(11) or nc not in range(11): continue

        if dxdy[d][1] == 0:
            if not cols[min(cur[0], nr)][nc]:
                cnt += 1
                cols[min(cur[0], nr)][nc] = True
        else:
            if not rows[nr][min(cur[1], nc)]:
                cnt += 1
                rows[nr][min(cur[1], nc)] = True

        cur[0], cur[1] = nr, nc

    return cnt


dirs = "URULDD"
print(solution(dirs))
