n = int(input())
a, b = map(int, input().split())

array = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
answer = -1

for _ in range(int(input())):
    c, p = map(int, input().split())
    array[c].append(p)
    array[p].append(c)

def dfs(start):
    global answer
    visited[start] = True
    
    if start == b:
        print(answer + 1)
        exit()
    
    for value in array[start]:
        if not visited[value]:
            answer += 1
            dfs(value)
            answer -= 1
dfs(a)
print(-1)