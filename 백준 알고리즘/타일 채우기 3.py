n = int(input())

dp = [1, 2, 7]

for i in range(3, n + 1):
    dp.append((dp[i - 1] * 3 + dp[i - 2] - dp[i - 3]) % 1000000007)
    
print(dp[n] % 1000000007) 