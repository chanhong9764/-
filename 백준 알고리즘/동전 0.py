n, k = map(int, input().split())

coin = []
answer = 0

for _ in range(n):
    temp = int(input())
    if temp <= k:
        coin.append(temp)
        
for value in reversed(coin):
    if k >= value:
        divide = k // value
        k -= value * divide
        answer += divide
        
        if k == 0:
            break
print(answer)