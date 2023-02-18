n, k = map(int, input().split())

dp = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    for j in range(i + 1):
        if i == 0 and j == 0:
            dp[i][j] = 1
        elif j == 0 or j == i:
            dp[i][j] = 1
        else:
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
print(dp[n][k] % 10007)