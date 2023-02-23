n, m = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]

dp = [[[int(1e9)] * 3 for _ in range(m)] for _ in range(n)]

for i in range(n):
    if i == 0:
        for j in range(m):
            for k in range(3):
                dp[i][j][k] = array[i][j]
    else:
        for j in range(m):
            if j == 0:
                dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + array[i][j]
                dp[i][j][1] = dp[i - 1][j][0] + array[i][j]
            elif j == m - 1:
                dp[i][j][1] = dp[i - 1][j][2] + array[i][j]
                dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + array[i][j]
            else:
                dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + array[i][j]
                dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + array[i][j]
                dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + array[i][j]

print(min(map(min, dp[-1])))