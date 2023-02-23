n, m = map(int, input().split())

square = [list(map(int, input())) for _ in range(n)]

dp = [[0] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if i == 0 or j == 0:
            dp[i][j] = square[i][j]
        elif square[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1

answer = max(map(max, dp))
print(answer * answer)