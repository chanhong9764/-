import sys
input = sys.stdin.readline

array = []

for _ in range(int(input())):
    start, end = map(int, input().split())
    array.append([start, end])

array.sort(key=lambda x: x[0])
array.sort(key=lambda x: x[1])
    
last = 0
answer = 0
    
for start, end in array:
    if start >= last:
        last = end
        answer += 1
            
print(answer)