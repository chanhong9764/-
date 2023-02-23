n = int(input())

array = list(map(int, input().split()))
reverseArray = list(reversed(array))

dp = [1] * n
dp2 = [1] * n

for i in range(n):
    for j in range(i):
        if array[i] > array[j]:
            dp[i] = max(dp[i], dp[j] + 1)
        if reverseArray[i] > reverseArray[j]:
            dp2[i] = max(dp2[i], dp2[j] + 1) 

print(dp, dp2)
result = [0] * n

for i in range(n):
    result[i] = dp[i] + dp2[n - i - 1] - 1
print(max(result))