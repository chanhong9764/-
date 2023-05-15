n, k = map(int, input().split())

array = []

dp = [[0] * (n + 1) for _ in range(k + 1)]

for i in range(k):
    a, b = map(int, input().split())
    array.append((a, b))

for i in range(1, k + 1):
    for j in range(1, n + 1):
        if array[i - 1][1] > j:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(array[i - 1][0] + dp[i - 1][j - array[i - 1][1]], dp[i - 1][j])
print(dp[k][n])