import sys
input = sys.stdin.readline
n, m, b = map(int, input().rstrip().split())

board = []

for _ in range(n):
    board.append(list(map(int, input().rstrip().split())))

maxValue = max(map(max, board))
minValue = min(map(min, board))

answer = []
for value in range(minValue, maxValue + 1):
    up = 0
    down = 0
    for i in range(n):
        for j in range(m):
            if value > board[i][j]:
                up +=  value - board[i][j]
            else:
                down += board[i][j] - value
    
    if b >= up - down:
        answer.append((up + down * 2, value))

sec, height = min(answer, key=lambda x : (x[0], -x[1]))
print(sec, height, sep=' ')