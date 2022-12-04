n = int(input())

array = list(map(int, input().split()))

# 이분 탐색을 위해서는 정렬이 되어 있어야 함
array.sort()

m = int(input())

findArray = list(map(int, input().split()))

for value in findArray:
    start = 0
    end = len(array) - 1
    
    isExist = False
    while start <= end:
        mid = (start + end) // 2
        
        if array[mid] < value:
            start = mid + 1
        else:
            end = mid - 1
            if array[mid] == value:
                isExist = True
                break
            
    if isExist:
        print('1')
    else:
        print('0')