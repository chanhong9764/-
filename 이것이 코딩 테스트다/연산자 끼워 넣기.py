n = int(input())

sequence = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

maxValue = -1e9
minValue = 1e9

def dfs(i, now):
    global minValue, maxValue, add, sub, mul, div
    
    if i == n:
        minValue = min(minValue, now)
        maxValue = max(maxValue, now)
    else:
        if add > 0:
            add -= 1
            dfs(i + 1, now + sequence[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i + 1, now - sequence[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i + 1, now * sequence[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i + 1, int(now / sequence[i]))
            div += 1

dfs(1, sequence[0])

print(maxValue)
print(minValue)