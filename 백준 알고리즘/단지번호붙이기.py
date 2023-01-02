n = int(input())

array = [list(map(int, input())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

count = 2
answer = 1
result = []

def dfs(x, y):
    global answer, count
    if array[x][y] == 1:
        array[x][y] = count

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= n or ny <= -1 or ny >= n:
                continue
            
            if array[nx][ny] == 1:
                answer += 1
                dfs(nx, ny)
    return answer

for i in range(n):
    for j in range(n):
        if array[i][j] == 1:
            result.append(dfs(i, j))
            count += 1
            answer = 1

print(count - 2)
for value in sorted(result):
    print(value)