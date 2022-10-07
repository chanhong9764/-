def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array, target, mid + 1, end)

n = int(input())

array = list(map(int, input().split()))
array.sort()

m = int(input())

parts = list(map(int, input().split()))

for part in parts:
    result = binary_search(array, part, 0, n - 1)
    if result != None:
        print("yes", end=' ')
    else:
        print("no", end=' ')
    