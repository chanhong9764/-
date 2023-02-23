n = int(input())

array = list(input())

dp = [int(1e9)] * n

def get_prev(x):
    if x=='B':
        return 'J'
    elif x=='J':
        return 'O'
    elif x=='O':
        return 'B'
    
dp[0] = 0
for i in range(1, n):
    prevValue = get_prev(array[i])
    for j in range(i):
        if prevValue == array[j]:
            dp[i] = min(dp[i], dp[j] + pow(i - j, 2))

print(dp[n-1] if dp[n-1] !=int(1e9) else -1)