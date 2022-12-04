while True:
    array = list(map(int, input().split()))
    maxValue = max(array)
    if array == [0, 0, 0]:
        break
    total = 0
    
    for value in array:
        if value != maxValue:
            total += (value*value)

    if total == (maxValue*maxValue):
        print('right')
    else:
        print('wrong')