import sys
sys.setrecursionlimit(10**7)
n = int(input())

array = [list(map(int, input().split())) for _ in range(n)]

answer = [0, 0, 0]

def divide(x, y, n):
    value = array[x][y]
    
    for i in range(x, x + n):
        for j in range(y, y + n):
            if value != array[i][j]:
                n = n // 3
                divide(x, y, n)
                divide(x, y + n, n)
                divide(x, y + 2*n, n)
                divide(x + n, y, n)
                divide(x + n, y + n, n)
                divide(x + n, y + 2*n, n)
                divide(x + 2*n, y, n)
                divide(x + 2*n, y + n, n)
                divide(x + 2*n, y + 2*n, n)
                return
                
    if value == -1:
        answer[0] += 1
    elif value == 0:
        answer[1] += 1
    else:
        answer[2] += 1

divide(0, 0, n)

for value in answer:
    print(value)