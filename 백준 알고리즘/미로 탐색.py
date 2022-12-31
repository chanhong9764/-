from collections import deque

n, m = map(int, input().split(' '))

array = [list(map(int, input())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue
            
            if array[nx][ny] == 0:
                continue
            
            if array[nx][ny] == 1:
                array[nx][ny] = array[x][y] + 1
                q.append((nx, ny))
                
    return array[n - 1][m - 1]

print(bfs(0, 0))