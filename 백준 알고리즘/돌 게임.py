n = int(input())

dp = [0] * 1001
dp[1] = True
dp[2] = False
dp[3] = True

for i in range(4, 1001):
    if dp[i - 1] or dp[i - 3]:
        dp[i] = False
    else:
        dp[i] = True
if dp[n]:
    print('SK')
else:
    print('CY')