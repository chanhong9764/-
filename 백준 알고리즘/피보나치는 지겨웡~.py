n = int(input())

dp = [1] * 51
dp[0] = 1
dp[1] = 1

def fibo(n):
    if dp[n] != 1 or n < 2:
        return dp[n]

    dp[n] += fibo(n - 2) + fibo(n - 1)

    return dp[n]
print(fibo(n) % 1000000007)