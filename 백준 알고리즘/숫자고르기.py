n = int(input())

array = [[0] + [i for i in range(1, n + 1)]]
array.append([0] + [int(input()) for _ in range(n)])

up = set()
down = set()

visited = [False] * (n + 1)
answer = []

def dfs(start):
    global visited, answer, up, down
    
    visited[start] = True
    
    up.add(start)
    down.add(array[1][start])
    
    if not visited[array[1][start]]:
        dfs(array[1][start])

    if up == down:
        for value in up:
            answer.append(value)
        up.clear()
        down.clear()
        return
    visited[start] = False
    
for i in range(1, n + 1):
    up.clear()
    down.clear()
    dfs(i)

answer.sort()
print(len(answer))
for value in answer:
    print(value)