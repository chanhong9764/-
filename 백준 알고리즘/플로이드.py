import sys
input = sys.stdin.readline
n = int(input())
m = int(input())

INF = 1e9
array = [[INF] * (n + 1) for _ in range(n + 1)]

for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            array[a][b] = 0
            
for _ in range(m):
    a, b, c = map(int, input().split())
    if c < array[a][b]:
        array[a][b] = c
    
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            array[a][b] = min(array[a][b], array[a][k] + array[k][b])
            
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if array[a][b] == INF:
            print("0", end=" ")
        else:
            print(array[a][b], end=" ")
    print('\n', end='')