from collections import deque
m, n = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

count = 0
answer = 0

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

q = deque()

for i in range(n):
    for j in range(m):
        if array[i][j] == 1:
            q.append((i, j))
            visited[i][j] = True
count = len(q)

while q:
    x, y = q.popleft()

    for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue
            if visited[nx][ny]:
                continue

            if array[nx][ny] == 0:
                q.append((nx, ny))
                array[nx][ny] = 1
                visited[nx][ny] = True
    count -= 1
    if count == 0:
        answer += 1
        count = len(q)
        

for k in range(n):
    if 0 in array[k]:
        print('-1')
        exit(0)
        
print(answer - 1)