n = int(input())

dol = [0] * (n + 1)

for i in range(1, n):
    s, l = map(int, input().split())
    dol[i] = (s, l)
k = int(input())

if n == 1:
    print(0)
elif n == 2:
    print(dol[1][0])
else:
    dp = [0] * (n + 1)
    dp[2] = dol[1][0]
    
    for i in range(3, n + 1):
        dp[i] = min(dp[i - 1] + dol[i - 1][0], dp[i - 2] + dol[i - 2][1])

    minValue = dp[-1]

    for i in range(1, n - 2):
        temp = dp[:]
        temp[i + 3] = temp[i] + k
        for j in range(i + 4, n + 1):
            temp[j] = min(temp[j], temp[j - 1] + dol[j - 1][0], temp[j - 2] + dol[j - 2][1])
        minValue = min(minValue, temp[-1])
        
    print(minValue)