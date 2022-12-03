from collections import deque
tc = int(input())

for _ in range(tc):
    n, m = map(int, input().split())

    array = list(map(int, input().split()))
    count = 0
    while array:
        maxValue = max(array)
        
        if array[0] < maxValue:
            array.append(array[0])
        else:
            count += 1
            if m == 0:
                break
        array.pop(0)
        m -= 1

        if m == -1:
            m = len(array) - 1
    print(count)
        