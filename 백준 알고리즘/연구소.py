from collections import deque
from itertools import combinations
import copy 
n, m = map(int, input().split())

array = []
position = []
virus = []
answer = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n):
    array.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if array[i][j] == 0:
            position.append((i, j))
        elif array[i][j] == 2:
            virus.append((i, j))
            
def bfs(temp):
    global virus
    q = deque([])
    for value in virus:
        q.append(value)

    visited = [[False] * m for _ in range(n)]
    visited[x][y] = True
    
    while q:
        a, b = q.popleft()
        
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            
            if temp[nx][ny] == 0:
                q.append((nx, ny))
                temp[nx][ny] = 1
                visited[nx][ny] = True

for values in combinations(position, 3):
    temp = copy.deepcopy(array)
    for x, y in values:
        temp[x][y] = 1
    bfs(temp)
    count = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                count +=1
    
    answer = max(answer, count)
print(answer)