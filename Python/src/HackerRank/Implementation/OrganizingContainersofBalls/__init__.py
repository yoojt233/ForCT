import sys

input = sys.stdin.readline


def organizingContainers(n, container):
    storages = [[0 for _ in range(n)] for _ in range(2)]
    for i in range(n):
        storages[0][i] = sum(container[i])
        for j in range(n):
            storages[1][j] += container[i][j]

    for i in storages:
        i.sort()

    flag = True
    for i in range(n):
        if storages[0][i] != storages[1][i]:
            flag = False
            break

    return "Possible" if flag else "Impossible"


if __name__ == '__main__':
    q = int(input().strip())

    for q_itr in range(q):
        n = int(input().strip())

        container = []

        for _ in range(n):
            container.append(list(map(int, input().rstrip().split())))

        result = organizingContainers(n, container)
        print(result + '\n')
