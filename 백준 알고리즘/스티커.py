tc = int(input())

for _ in range(tc):
    n = int(input())
    array = [list(map(int, input().split())) for _ in range(2)]
    
    for i in range(1, n):
        if i == 1:
            array[0][i] += array[1][i - 1]
            array[1][i] += array[0][i - 1]
        else:
            array[0][i] += max(array[1][i - 1], array[1][i - 2])
            array[1][i] += max(array[0][i - 1], array[0][i - 2])
            
    print(max(array[0][n - 1], array[1][n - 1]))