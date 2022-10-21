import heapq

n = int(input())

data = []
array = []

answer = 0

for _ in range(n):
    heapq.heappush(data, int(input()))
    
while data and len(data) != 1:
    a = heapq.heappop(data)
    b = heapq.heappop(data)
    sum = a + b
    heapq.heappush(data, sum)
    answer += sum

print(answer)