n = int(input())

number = list(map(int, input().split()))
maxDP = [1] * n
minDP = [1] * n

for i in range(1, n):
    if number[i] >= number[i - 1]:
        maxDP[i] = maxDP[i - 1] + 1
    if number[i] <= number[i - 1]:
        minDP[i] = minDP[i - 1] + 1
        
print(max(max(maxDP), max(minDP)))