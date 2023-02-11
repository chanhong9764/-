c, n = map(int, input().split())

cost = []

dp = [int(1e9)] * (c + 100)
dp[0] = 0

for _ in range(n):
    cost.append(map(int, input().split()))
    
    
for v, p in cost:
    for i in range(c + 100):
        dp[i] = min(dp[i - p] + v, dp[i])

print(min(dp[c:]))