n, m, k = map(int, input().split())

array = [[0] * (m + 1) for _ in range(n + 1)]

x, y = n, m
count = 1

for i in range(1, n + 1):
    for j in range(1, m + 1):
        array[i][j] = count
        if count == k:
            x, y = i, j
        count += 1

dp = [[-1] * (m + 1) for _ in range(n + 1)] 
dx = [0, 1]
dy = [1, 0]

def dfs(a, b, c, d):
    if a == c and b == d:
        return 1
    
    if dp[a][b] != -1:
        return dp[a][b]
    
    dp[a][b] = 0

    for i in range(2):
        nx = a + dx[i]
        ny = b + dy[i]

        if nx >= c + 1 or ny >= d + 1:
            continue

        dp[a][b] += dfs(nx, ny, c, d)
            
    return dp[a][b]
    
print(dfs(1, 1, x, y) * dfs(x, y, n, m))