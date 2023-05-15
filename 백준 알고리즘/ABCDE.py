n, m = map(int, input().split())

array = [[] for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    array[a].append(b)
    array[b].append(a)
    
visited = [False] * n

def dfs(start, cnt):
    if cnt == 4:
        print(1)
        exit()

    for value in array[start]:
        if not visited[value]:
            visited[value] = True
            dfs(value, cnt + 1)
            visited[value] = False

for value in range(n):
    visited[value] = True
    dfs(value, 0)
    visited[value] = False

print(0)