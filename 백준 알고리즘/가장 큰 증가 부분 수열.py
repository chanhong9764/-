n = int(input())

number = list(map(int, input().split()))
dp = number[:]

for i in range(1, n):
    for j in range(i):
        if number[i] > number[j]:
            dp[i] = max(dp[i], dp[j] + number[i])
print(max(dp))