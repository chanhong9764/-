n = int(input())

array = list(map(int, input().split()))

dp = [[0] * 21 for _ in range(n - 1)]

dp[0][array[0]] = 1

for i in range(1, n - 1):
    for j in range(21):
        if j - array[i] >= 0:
            dp[i][j - array[i]] += dp[i - 1][j]
        if j + array[i] <= 20:
            dp[i][j + array[i]] += dp[i - 1][j]

print(dp[-1][array[-1]])