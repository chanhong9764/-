for _ in range(int(input())):
    k = int(input())
    n = int(input())
    
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
    
    for i in range(1, k + 1):
        for j in range(14):
            temp = 0
            for l in range(j + 1):
                temp += array[14 * (i - 1) + l]
            array.append(temp)
    
    if k == 0:
        print(array[k + n - 1])
    else:
        print(array[(14 * k) + n - 1])
    