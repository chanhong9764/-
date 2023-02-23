import sys
input = sys.stdin.readline

n, m = map(int, input().split())

dp = [1] * (n + 1)

array = [list(map(int, input().split())) for _ in range(m)]
array.sort(key=lambda x : (x[0], x[1]))

for a, b in array:
    dp[b] = max(dp[b], dp[a] + 1)

for i in range(1, n + 1):
    print(dp[i], end=' ')