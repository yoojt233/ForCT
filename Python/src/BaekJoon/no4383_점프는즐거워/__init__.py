import sys

input = sys.stdin.readline

while True:
    try:
        jj = list(map(int, input().rstrip().split()))

        flag = True
        if jj[0] > 1:
            dif = []

            for i in range(1, jj[0]):
                dif.append(abs(jj[i] - jj[i + 1]))

            for i in range(1, jj[0]):
                if not i in dif:
                    flag = False
                    break
        print("Jolly" if flag else "Not jolly")

    except:
        break
