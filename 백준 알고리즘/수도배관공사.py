import sys
input = sys.stdin.readline

d, p = map(int, input().split())
dp = [1e9]+[0]*d
for _ in range(p):
    l, c = map(int, input().split())
    dp_max = dp.copy()
    print(dp_max)
    for i in range(l, d+1):
        if dp_max[i - l] :
            dp[i] = max(dp[i], min(dp_max[i-l], c))
print(dp[d])