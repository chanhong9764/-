import sys
sys.setrecursionlimit(10**7)
n = int(input())

dp = [0] * (n + 1)
dp[0] = 1

def t(n):
    if dp[n] != 0:
        return dp[n]
    for i in range(n):
        dp[n] += t(n - 1 - i) * t(i)

    return dp[n]
        
print(t(n))