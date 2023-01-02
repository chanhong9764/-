n = int(input())

graph = [[False] * n for _ in range(n)]

for i in range(n):
    values = list(map(int, input().split()))
    for j in range(len(values)):
        if values[j] == 1:
            graph[i][j] = True

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = True
                
for i in range(n):
    for j in range(n):
        if graph[i][j]:
            print(1, end=' ')
        else:
            print(0, end=' ')
    print('')