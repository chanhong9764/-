n = int(input())

array = [(0, 0)]
dp = [0] * (n + 1) 

for i in range(n):
    t, p = map(int, input().split())
    array.append((t, p))

for i in range(1, n + 1):
    t, p = array[i]
    dp[i] = max(dp[i], dp[i - 1])
    
    temp = i + t - 1
    if temp <= n :
        dp[temp] = max(dp[temp], dp[i - 1] + p)
        
print(dp[-1])