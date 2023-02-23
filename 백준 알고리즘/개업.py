n, m = map(int, input().split())

wok = list(map(int, input().split()))

dp = [int(1e9)] * (n + 1)

dp[0] = 0
for i in range(m):
    dp[wok[i]] = 1
    for j in range(i + 1, m):
        dp[wok[i] + wok[j]] = 1
        
for i in range(1, n + 1):
    for j in range(1, (i // 2) + 1):
        if dp[i - j] != int(1e9) and dp[j] != int(1e9):
            dp[i] = min(dp[i], dp[i - j] + dp[j])

print(dp[-1])