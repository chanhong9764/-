import sys
input = sys.stdin.readline
from collections import deque

r, c, n = map(int, input().split())

array = [list(input()) for _ in range(r)]
bomb = deque([])
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def findbomb():
    for i in range(r):
        for j in range(c):
            if array[i][j] == 'O':
                bomb.append((i, j))

def bfs():
    global bomb
    
    while bomb:
        x, y = bomb.popleft()
        
        array[x][y] = '.'

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= -1 or nx >= r or ny <= -1 or ny >= c:
                continue
            array[nx][ny] = '.'
        
def install():
    global bomb
    for i in range(r):
        for j in range(c):
            if array[i][j] == '.':
                array[i][j] = 'O'

n -= 1  
while n:
    findbomb()
    install()
    n -= 1
    if n == 0:
        break
    bfs()
    n -= 1
        
for i in range(r):
    for j in range(c):
        print(array[i][j], end='')
    print(' ')