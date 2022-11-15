for tc in range(1, 11):
    answer = 0
    count = int(input())
    array = [[0] * count for _ in range(256)]
    building = list(map(int, input().split()))

    for i in range(count):
        for j in range(building[i]):
            array[255 - j][i] = 1
            
    for i in range(256):
        for j in range(count):
            if array[i][j] == 1:
                if array[i][j - 1] != 1 and array[i][j - 2] != 1 and array[i][j + 1] != 1 and array[i][j + 2] != 1:
                    answer += 1
                    
    print(f'#{tc} {answer}')