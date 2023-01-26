import sys
input = sys.stdin.readline
n, m = map(int, input().split())

data = list(map(int, input().split()))

dp = [0]

for i in range(1, n + 1):
    dp.append(dp[i - 1] + data[i - 1])

for _ in range(m):
    i, j = map(int, input().split())
    print(dp[j] - dp[i - 1])