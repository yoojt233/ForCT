import math
import os
import random
import re
import sys



# Complete the flatlandSpaceStations function below.
def flatlandSpaceStations(n, c):
    ans = 0
    dist = [10**6 for _ in range(n)]
    
    for i in range(len(c)):
        cur = c[i]
        dist[cur] = 0
        
        while True:
            cur -= 1
            if cur in c or cur < 0 or dist[cur] <= c[i] - cur: break
            dist[cur] = c[i] - cur
        
        cur = c[i]
        while True:
            cur += 1
            if cur in c or cur >= n or dist[cur] <= cur - c[i]: break
            dist[cur] = cur - c[i]
            
    return sorted(dist)[-1]



if __name__ == '__main__':
     nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    c = list(map(int, input().rstrip().split()))

    result = flatlandSpaceStations(n, c)

    fptr.write(str(result) + '\n')

    fptr.close()