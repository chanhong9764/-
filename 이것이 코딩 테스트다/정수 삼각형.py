n = int(input())

data = []

for _ in range(n):
    data.append(list(map(int, input().split())))
    
for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            left = 0
        else:
            left = data[i - 1][j - 1]
        
        if  j == i:
            right = 0
        else:
            right = data[i - 1][j]
        
        data[i][j] = data[i][j] + max(left, right)
    
print(max(data[n - 1]))