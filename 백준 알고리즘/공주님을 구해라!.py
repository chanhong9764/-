from collections import deque

n, m, t = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

answer = 10001

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(a, b):
    global answer
    q = deque([(a, b, 0)])
    visited[a][b] = True
    
    while q:
        x, y, d = q.popleft()

        if x == n - 1 and y == m - 1:
            answer = min(answer, d)
            break
        if d+1 > t:
            break
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= m or visited[nx][ny]:
                continue
            if array[nx][ny] == 1:
                continue
            elif array[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny, d + 1))
            else:
                visited[nx][ny] = True
                diff = d + 1 + abs(nx - (n - 1)) + abs(ny - (m - 1))
                if diff <= t:
                    answer = diff
bfs(0, 0)
print(answer)