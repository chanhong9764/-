n = int(input())

num = list(map(int, input().split()))
sortArray = sorted(set(num))

start = 0
end = len(sortArray) - 1

def binarySearch(start, end, value):
    while start <= end:
        index = (start + end) // 2
        
        if sortArray[index] == value:
            return index
        elif sortArray[index] > value:
            end = index - 1
        else:
            start = index + 1
    return None

for value in num:
    print(binarySearch(start, end, value), end=' ')