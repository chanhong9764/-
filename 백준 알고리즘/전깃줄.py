n = int(input())

array = [list(map(int, input().split())) for _ in range(n)]

array.sort(key=lambda x: x[0])

dp = [1] * n

for i in range(n):
    for j in range(i):
        if array[i][1] > array[j][1]:
            dp[i] = max(dp[i], dp[j] + 1)
print(n - max(dp))