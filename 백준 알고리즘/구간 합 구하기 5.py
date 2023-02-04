import sys, copy
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())

array = []

for _ in range(n):
    array.append(list(map(int, input().split())))

for i in range(n):
    for j in range(1, n):
        array[i][j] += array[i][j - 1]
        
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    
    answer = 0
    for i in range(x1 - 1, x2):
        if y1 - 2 < 0:
            answer += array[i][y2 - 1]
        else:
            answer += (array[i][y2 - 1] - array[i][y1 - 2]) 
    print(answer)