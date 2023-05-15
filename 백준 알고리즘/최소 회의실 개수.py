import heapq, sys
input = sys.stdin.readline

n = int(input())

q = []

array = [list(map(int, input().split())) for _ in range(n)]

array.sort()
heapq.heappush(q, array[0][1])

for i in range(1, n):
    if q[0] > array[i][0]:
        heapq.heappush(q, array[i][1])
    else:
        heapq.heappop(q)
        heapq.heappush(q, array[i][1])

print(len(q))