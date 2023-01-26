tc = int(input())

for _ in range(tc):
    n = int(input())
    
    dp = [0, 1, 1, 1, 2]
    
    for i in range(5, n + 1):
        dp.append(dp[i - 1] + dp[i - 5])
    print(dp[n])