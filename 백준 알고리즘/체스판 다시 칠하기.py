n, m = map(int, input().split())

board = []
count = []

for _ in range(n):
    board.append(input())

for i in range(n - 7):
    for j in range(m - 7):
        w_index = 0
        b_index = 0
        for k in range(i, i + 8):
            for l in range(j, j + 8):
                if (k + l) % 2 == 0:
                    if board[k][l] != 'W':
                        w_index += 1
                    else:
                        b_index += 1
                else:
                    if board[k][l] != 'W':
                        b_index += 1
                    else: 
                        w_index += 1
        count.append(w_index)
        count.append(b_index)
        
print(min(count))