import sys
input = sys.stdin.readline

INF = int(1e9)

n, m = map(int, input().split())

array = [[INF] * (n + 1) for _ in range(n + 1)]
answer = -1
total = INF
         
for _ in range(m):
    a, b = map(int, input().split())
    array[a][b] = 1
    array[b][a] = 1
            
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            array[a][b] = min(array[a][b], array[a][k] + array[k][b])

for a in range(1, n + 1):
    temp = 0
    for b in range(1, n + 1):
        if INF != array[a][b]:
            temp += array[a][b]
    if temp < total:
        total = temp
        answer = a
print(answer)