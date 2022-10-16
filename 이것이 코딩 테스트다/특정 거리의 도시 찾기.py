from collections import deque

n, m, k, x = map(int, input().split())

road = [[] for _ in range(n + 1)]
distance = [-1] * (n + 1)
distance[x] = 0

for _ in range(m):
    a, b = map(int, input().split())
    road[a].append(b)

queue = deque([x])
    
while queue:
    now = queue.popleft()
    
    for next_node in road[now]:
        if distance[next_node] == -1:
            distance[next_node] = distance[now] + 1
            queue.append(next_node)

check = False
for i in range(1, n + 1):
    if distance[i] == k:
        print(i)
        check = True
        
if not check:
    print(-1)