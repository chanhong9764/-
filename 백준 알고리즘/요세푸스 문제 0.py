n, k = map(int, input().split())

array = [i for i in range(1, n + 1)]

count = 1
index = 0
answer = []

while len(answer) != n: 
    if count == k:
        answer.append(array[index])
        array[index] = 0
        count = 0
        
    index += 1
    if index >= n:
        index = 0
        
    if array[index] != 0:
        count += 1
        
print('<', end='')
print(*answer, sep=', ', end='>')