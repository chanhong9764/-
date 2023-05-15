from collections import deque

n, m = map(int, input().split())

answer = 0
array = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
virus = []

for i in range(n):
    for j in range(n):
        if array[i][j] == 2:
            virus.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(v):
    global answer
    q = deque(v)
    length = len(q)
    init_x, init_y = q[0]
    visited[init_x][init_y] = True
    print(q)
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= n or visited[nx][ny]:
                continue
            if array[nx][ny] == 1:
                continue
            if array[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = True
        length -= 1
        if length <= 1:
            print(q)
            answer += 1
            length = len(q)

bfs(virus)
print(answer)