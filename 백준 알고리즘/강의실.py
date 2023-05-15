import heapq, sys
input = sys.stdin.readline
n = int(input())

array = [list(map(int, input().split())) for _ in range(n)]

array.sort(key=lambda x : x[1])

q = []
heapq.heappush(q, array[0][2])

for i in range(1, n):
    if q[0] > array[i][1]:
        heapq.heappush(q, array[i][2])
    else:
        heapq.heappop(q)
        heapq.heappush(q, array[i][2])
print(len(q))