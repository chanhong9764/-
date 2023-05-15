import heapq

n, k = map(int, input().split())

INF = int(1e9)

distance = [INF] * 100001

def dijkstra(start):
    global distance
    q = []
    
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue

        if now - 1 >= 0:
            if distance[now - 1] > dist + 1:
                distance[now - 1] = dist + 1
                heapq.heappush(q, (dist + 1, now - 1))
        if now + 1 <= 100000:
            if distance[now + 1] > dist + 1:
                distance[now + 1] = dist + 1
                heapq.heappush(q, (dist + 1, now + 1))
        if now * 2 <= 100000:
            if distance[now * 2] > dist:
                distance[now * 2] = dist
                heapq.heappush(q, (dist, now * 2))
                
dijkstra(n)
print(distance[k])