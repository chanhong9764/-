n = int(input())

array = []

for _ in range(n):
    x, y = map(int, input().split())
    array.append((x, y))
    
for i in range(n):
    rank = n
    x, y = array[i]
    for j in range(n):
        if i != j:
            p, q = array[j]
            if x >= p or y >= q:
                rank -= 1            
    print(rank, end=' ')