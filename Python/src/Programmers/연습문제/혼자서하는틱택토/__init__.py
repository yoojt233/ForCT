def isWin(t, board):
    bingo = [t, t, t]

    for i in range(3):
        if (list(board[i]) == bingo) or ([board[r][i] for r in range(3)]) == bingo: return True

    if ([board[i][i] for i in range(3)] == bingo) or ([board[2 - i][i] for i in range(3)] == bingo):
        return True

    return False


def solution(board):
    ox = [0, 0]
    for line in board:
        ox[0] += line.count('O')
        ox[1] += line.count('X')

    if not (0 <= ox[0] - ox[1] <= 1): return 0

    O_win, X_win = isWin('O', board), isWin('X', board)
    if (O_win and X_win) or (O_win and ox[0] == ox[1]) or (X_win and ox[0] > ox[1]): return 0

    return 1


board = ["...", "...", "..."]
print(solution(board))
