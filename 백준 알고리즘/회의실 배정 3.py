import sys
input = sys.stdin.readline
n = int(input())

array = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * n

for i in range(n):
    if i == 0:
        dp[i] = array[i][2]
    elif i == 1:
        dp[i] = max(array[i - 1][2], array[i][2])
    else:
        dp[i] = max(dp[i - 2] + array[i][2], dp[i - 1])
        
print(dp[-1])