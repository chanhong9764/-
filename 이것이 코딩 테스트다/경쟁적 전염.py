from collections import deque

n, k = map(int, input().split())

data = []
virus_info = []

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    data.append(list(map(int, input().split())))
    for j in range(n):
        if data[i][j] != 0:
            virus_info.append((data[i][j], 0, i, j))

virus_info.sort()
queue = deque(virus_info)

target_s, target_x, target_y = map(int, input().split())

while queue:
    virus, s, x, y = queue.popleft()
    if s == target_s:
        break
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx >= 0 and nx < n and ny >= 0 and ny < n:
            if data[nx][ny] == 0:
                data[nx][ny] = virus
                queue.append((data[nx][ny], s + 1, nx, ny))
                
print(data[target_x - 1][ target_y - 1])