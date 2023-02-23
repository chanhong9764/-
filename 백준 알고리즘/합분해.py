n, k = map(int, input().split())

number = [i for i in range(n + 1)]

dp = [[0] * (n + 1) for _ in range(k + 1)]

for i in range(1, k + 1):
    for j in range(1, n + 1):
        if j == 1:
            dp[i][j] = i
        else:
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]

print(dp[-1][-1] % 1000000000)