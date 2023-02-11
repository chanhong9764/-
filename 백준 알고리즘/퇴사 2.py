import sys
inpuy = sys.stdin.readline
n = int(input())

day = [0] * (n + 1)
money = [0] * (n + 1)
dp = [0] * (n + 1)

for i in range(1, n + 1):
    day[i], money[i] = map(int, input().split())
    
for i in range(1, n + 1):
    dp[i] = max(dp[i], dp[i - 1])
    
    temp = i + day[i] - 1
    if temp <= n:
        dp[temp] = max(dp[temp], dp[i - 1] + money[i])
print(max(dp))