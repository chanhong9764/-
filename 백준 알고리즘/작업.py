n = int(input())

dp = [0] * (n + 1)

for i in range(1, n + 1):
    job = list(map(int, input().split()))
    
    if job[1] == 0:
        dp[i] = job[0]
    else:
        for j in range(1, job[1] + 1):
            dp[i] = max(dp[i], dp[job[1 + j]] + job[0])
print(max(dp))