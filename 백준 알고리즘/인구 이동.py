from collections import deque

n, l, r = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
count = 0

check = False
def bfs(a, b):
    global check, visited
    q = deque([(a, b)])
    visited[a][b] = True
    
    temp = [(a, b)]
    total = array[a][b]
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= n or visited[nx][ny]:
                continue
            if l <= abs(array[x][y] - array[nx][ny]) <= r:
                visited[nx][ny] = True
                q.append((nx, ny))
                total += array[nx][ny]
                temp.append((nx, ny))
                check = True
                
    if len(temp) >= 2:
        for a, b in temp:
            array[a][b] = total // len(temp)

while True:
    visited = [[False] * n for _ in range(n)]
    check = False
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                bfs(i, j)
    count += 1
    if not check:
        print(count - 1)
        break