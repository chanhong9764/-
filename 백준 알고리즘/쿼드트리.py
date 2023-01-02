n = int(input())

array = [list(map(int, input())) for _ in range(n)]

def divide(x, y, n):
    value = array[x][y]
    
    for i in range(x, x + n):
        for j in range(y, y + n):
            if value != array[i][j]:
                temp = n // 2
                print('(', end='')
                divide(x, y, temp)
                divide(x, y + temp, temp)
                divide(x + temp, y, temp)
                divide(x + temp, y + temp, temp)
                print(')', end='')
                return
            
    print(value, end='')
    
divide(0, 0, n)