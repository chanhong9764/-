n = int(input())

array = [0] * 10001

for _ in range(n):
    array[int(input())] += 1
    
for i in range(1, 10001):
    for j in range(array[i]):
        print(i)