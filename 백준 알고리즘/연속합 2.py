n = int(input())

number = list(map(int, input().split()))

dp = [[value for value in number] for _ in range(2)]

for i in range(1, n):
    dp[0][i] = max(dp[0][i], dp[0][i - 1] + number[i])
    dp[1][i] = max(dp[0][i - 1], dp[1][i - 1] + number[i])

print(max(map(max, dp)))