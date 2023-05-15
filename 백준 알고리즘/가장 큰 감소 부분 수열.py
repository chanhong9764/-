n = int(input())

array = list(map(int, input().split()))

dp = [0] * n

for i in range(n):
    dp[i] = array[i]
    for j in range(i):
        if array[i] < array[j]:
            dp[i] = max(dp[i], dp[j] + array[i])
print(max(dp))