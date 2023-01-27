from collections import deque
m, n, h = map(int, input().split())

array = []
visited = [[[False] * m for _ in range(n)] for _ in range(h)]

for _ in range(h):
    temp = []
    for _ in range(n):
        temp.append(list(map(int, input().split())))
    array.append(temp)

q = deque()
answer = 0

dh = [1, -1]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in range(h):
    for j in range(n):
        for k in range(m):
            if array[i][j][k] == 1:
                q.append((i, j, k))
                visited[i][j][k] = True

count = len(q)

while q:
    i, j, k = q.popleft()
    
    for a in range(2):
        nh = i + dh[a]
        
        if nh <= -1 or nh >= h:
            continue
        if visited[nh][j][k]:
            continue
        
        if array[nh][j][k] == 0:
            q.append((nh, j, k))
            array[nh][j][k] = 1
            visited[nh][j][k] = True
            
    for b in range(4):
        nx = j + dx[b]
        ny = k + dy[b]
        
        if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
            continue
        if visited[i][nx][ny]:
            continue

        if array[i][nx][ny] == 0:
            q.append((i, nx, ny))
            array[i][nx][ny] = 1
            visited[i][nx][ny] = True
    count -= 1
    
    if count == 0:
        answer += 1
        count = len(q)

for i in range(h):
    for j in range(n):
        if 0 in array[i][j]:
            print('-1')
            exit(0)
print(answer - 1)