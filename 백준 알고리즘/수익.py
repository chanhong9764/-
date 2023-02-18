import sys
input = sys.stdin.readline

while True:
    n = int(input())
    if n == 0:
        break
    
    array = [int(input()) for _ in range(n)]
    dp = array[:]
    
    for i in range(1, n):
        dp[i] = max(dp[i], dp[i - 1] + array[i])
    print(max(dp))