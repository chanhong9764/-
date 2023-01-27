import sys, heapq
input = sys.stdin.readline
n, m, x = map(int, input().split())

INF = 1e9

array = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    array[a].append((b, c))
    
def dijkstra(start):
    q = []
    distance = [INF] * (n + 1) 
    
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue
        
        for i in array[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

result = 0
for i in range(1, n + 1):
    go = dijkstra(i)
    back = dijkstra(x)
    result = max(result, go[x] + back[i])

print(result)