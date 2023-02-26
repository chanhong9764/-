import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n, m = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

maxValue = 0

def dfs(x, y, dsum, cnt):
    global maxValue
    
    if cnt == 4:
        maxValue = max(maxValue, dsum)
        return
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
            continue
        
        if not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, dsum + array[nx][ny], cnt + 1)
            visited[nx][ny] = False
                
def exce(x, y):
    global maxValue
    
    for l in range(4):
        tmp = array[x][y]
        for k in range(3):
            t = (l + k) % 4
            nx = x + dx[t]
            ny = y + dy[t]

            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                tmp = 0
                break
            tmp += array[nx][ny]

        maxValue = max(maxValue, tmp)

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, array[i][j], 1)
        visited[i][j] = False
        
        exce(i, j)

print(maxValue)