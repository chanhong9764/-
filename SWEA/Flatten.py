for tc in range(1, 11):
    count = int(input())
    array = list(map(int, input().split()))

    for _ in range(count):
        maxValue = max(array)
        minValue = min(array)
        
        maxIndex = array.index(maxValue)
        minIndex = array.index(minValue)
        maxValue -= 1
        minValue += 1
        array[maxIndex] = maxValue
        array[minIndex] = minValue
        
    print(f'#{tc} {max(array)-min(array)}')