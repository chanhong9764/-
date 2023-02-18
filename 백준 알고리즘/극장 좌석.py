n = int(input())

array = [i for i in range(n + 1)]
dp = [1] * (n + 1)

for i in range(int(input())):
    array[int(input())] = 0

for i in range(2, n + 1):
    if array[i] == 0 or array[i - 1] == 0:
        dp[i] = dp[i - 1]
    else:
        dp[i] = dp[i - 2] + dp[i - 1]
        
print(dp[-1])