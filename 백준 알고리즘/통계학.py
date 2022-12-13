import sys
import heapq
input = sys.stdin.readline
n = int(input())

array = [0] * 8001

maxValue = -4001
minValue = 4001
avg = 0
for i in range(n):
    number = int(input())
    avg += number
    if number > maxValue:
        maxValue = number
    if number < minValue:
        minValue = number
    array[4000 + number] += 1
    

center = 0
modeValue = 0
modeValueArray = []

count = 0
for i in range(8001):
    for j in range(array[i]):
        if count == n // 2:
            center = i - 4000
        count += 1
        
    if modeValue < array[i]:
        modeValue = array[i]
        modeValueArray.clear()
        heapq.heappush(modeValueArray, i - 4000)
    elif modeValue == array[i]:
        heapq.heappush(modeValueArray,i - 4000)
        
print(round(avg / n))
print(center)
if len(modeValueArray) != 1:
    print(modeValueArray[1])
else:
    print(modeValueArray[0])
    
print(maxValue - minValue)