n = int(input())

dp = [int(1e9)] * (n + 1)

for i in range(1, n + 1):
    if i == 2 or i == 5:
        dp[i] = 1
    elif i == 4:
        dp[i] = 2
    if i > 5:
        dp[i] = min(dp[i - 2], dp[i - 5]) + 1

if dp[n] == int(1e9):
    print(-1)
else:
    print(dp[n])