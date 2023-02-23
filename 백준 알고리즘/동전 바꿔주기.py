t = int(input())
k = int(input())

array = [list(map(int, input().split())) for _ in range(k)]

dp = [0] * (t + 1)
dp[0] = 1

for v, c in array:
    for i in range(t, 0, -1):
        for j in range(1, c + 1):
            if i - (v * j) >= 0:
                dp[i] += dp[i - v * j]

print(dp[-1])