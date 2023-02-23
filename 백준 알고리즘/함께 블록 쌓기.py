n, m, h = map(int, input().split())

dp = [[1] + [0] * h for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i] = dp[i - 1][:]
    blocks = list(map(int, input().split()))
    for block in blocks:
        for j in range(block, h + 1):
            dp[i][j] += dp[i - 1][j - block]

print(dp[-1][-1] % 10007)