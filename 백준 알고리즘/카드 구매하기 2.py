n = int(input())

number = [0] + list(map(int, input().split()))

dp = number[:]

for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i] = min(dp[i], dp[i - j] + number[j])

print(dp[-1])