n, k = map(int, input().split())

cost = []
dp = [0] * (k + 1)

for _ in range(n):
    w, v = map(int, input().split())
    cost.append((w, v))

for w, v in cost:
    for i in range(k, w - 1, -1):
        dp[i] = max(dp[i], dp[i - w] + v)
print(max(dp))