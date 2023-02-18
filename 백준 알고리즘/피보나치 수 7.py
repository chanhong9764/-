n = int(input())

dp = [0, 1, 1]

for i in range(3, n + 1):
    dp.append(dp[i - 2] % 1000000007 + dp[i - 1] % 1000000007)

print(dp[n] % 1000000007)