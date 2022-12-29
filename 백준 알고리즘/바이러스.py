n = int(input())

array = [[] for _ in range(101)]
visited = [False] * 101
count = 0

for _ in range(int(input())):
    index, connect = map(int, input().split(' '))
    array[index].append(connect)
    array[connect].append(index)

def dfs(graph, target, visited):
    global count
    visited[target] = True
    count += 1
    
    for value in graph[target]:
        if not visited[value]:
            dfs(graph, value, visited)

dfs(array, 1, visited)
print(count - 1)