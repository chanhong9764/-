import sys
import copy
sys.setrecursionlimit(10**6)
n = int(input())

array = [list(input()) for _ in range(n)]
copyArray = copy.deepcopy(array)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

normal = 0
abnormal = 0

for i in range(n):
    for j in range(n):
        if array[i][j] == 'G':
            array[i][j] = 'R'
            
def dfs(x, y, array):
    value = array[x][y]
    array[x][y] = True
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx <= -1 or nx >= n or ny <= -1 or ny >= n:
            continue
        
        if array[nx][ny] == value:
            dfs(nx, ny, array)
            
for i in range(n):
    for j in range(n):
        if array[i][j] != True:
            dfs(i, j, array)
            abnormal += 1
            
        if copyArray[i][j] != True:
            dfs(i, j, copyArray)
            normal += 1
            
print(normal, abnormal, sep=' ')