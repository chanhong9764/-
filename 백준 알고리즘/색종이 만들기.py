n = int(input())

paper = []

one = 0
zero = 0

for _ in range(n):
    paper.append(list(map(int, input().split(' '))))

def divide(length, row, col):
    global one, zero
    check = True
    
    for i in range(length):
        for j in range(length):
            if (paper[row][col] == 1 and paper[row+i][col+j] != 1) or (paper[row][col] == 0 and paper[row+i][col+j] != 0):
                check = False
                divide(length // 2, row+0, col+0)
                divide(length // 2, row+0, col+length // 2)
                divide(length // 2, row+length // 2, col+0)
                divide(length // 2, row+length // 2, col+length // 2)
                return
                
    if check:          
        if paper[row][col] == 1:
            one += 1
        else:
            zero += 1

divide(n, 0, 0)

print(zero, one, sep='\n')