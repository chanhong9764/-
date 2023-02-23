n = int(input())
array = [[0] * (n + 1)]

for _ in range(n):
    array.append([0] + list(map(int, input().split())))

dp = [[-1] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if array[i][j] == 0:
            dp[i][j] = 1
        if dp[i - 1][j] % 3 == array[i][j]:
            dp[i][j] = max(dp[i][j], dp[i - 1][j] + 1)
        if dp[i][j - 1] % 3 == array[i][j]:
            dp[i][j] = max(dp[i][j], dp[i][j - 1] + 1)
        dp[i][j] = max(dp[i][j], dp[i - 1][j], dp[i][j - 1])
print(dp)
answer = max(map(max, dp))
if answer != -1:
    print(answer)
else:
    print(0)