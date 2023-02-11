n = int(input())

array = [list(map(int, input().split())) for _ in range(n)]

dp = [[-1] * n for _ in range(n)]

def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return 0
    
    if x == n - 1 and y == n - 1:
        return 1
    
    if dp[x][y] == -1:
        dp[x][y] = 0
        jump = array[x][y]
        
        nx = x + jump # 아래
        ny = y + jump # 오른쪽
        
        dp[x][y] += dfs(x, ny)
        dp[x][y] += dfs(nx, y)
    
    return dp[x][y]

print(dfs(0, 0))