n = int(input())

wine = [int(input()) for _ in range(n)]

if n < 3:
    print(sum(wine))
else:
    dp = []
    dp.append(wine[0])
    dp.append(wine[0] + wine[1])
    dp.append(max(wine[0] + wine[2], wine[1] + wine[2], dp[1]))

    for i in range(3, n):
        dp.append(max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i], dp[i - 1]))
    print(dp[-1])