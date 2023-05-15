array = []

while True:
    try:
        array.append(list(map(int, input().split())))
    except:
        break
    
def checkRow(x, y, num):
    ny = y + 5
    ny2 = y - 1
    if ny < 19:
        if array[x][ny] == num:
            return False
    if ny2 > -1:
        if array[x][ny2] == num:
            return False
    check = True
    for i in range(5):
        if array[x][y + i] != num:
            check = False
    return check 
    
def checkCol(x, y, num):
    nx = x + 5
    nx2 = x - 1
    if nx < 19:
        if array[nx][y] == num:
            return False
    if nx2 > -1:
        if array[nx2][y] == num:
            return False
    check = True
    for i in range(5):
        if array[x + i][y] != num:
            check = False
    return check
     
def checkDiagonal(x, y, num):
    nx = x + 5
    ny = y + 5
    ny2 = y - 1
    nx2 = x - 1
    if nx < 19 and ny < 19:
        if array[nx][ny] == num:
            return False
    if nx2 > -1 and ny2 > -1:
        if array[nx2][ny2] == num:
            return False
    check = True
    for i in range(5):
        if array[x + i][y + i] != num:
            check = False
    return check 
    
def checkDiagonal2(x, y, num):
    nx = x + 1
    ny = y - 1
    ny2 = y + 5
    nx2 = x - 5
    if nx < 19 and ny > -1 :
        if array[nx][ny] == num:
            return False
    if nx2 > -1 and ny2 < 19:
        if array[nx2][ny2] == num:
            return False
    check = True
    for i in range(5):
        if array[x - i][y + i] != num:
            check = False
    return check 
    
for i in range(len(array)):
    for j in range(len(array[0]) - 4):
        if array[i][j] == 1:
            check = False
            if i < len(array) - 4:
                if checkCol(i, j, 1) or checkDiagonal(i, j, 1):
                    check = True
            if checkRow(i, j, 1)  or checkDiagonal2(i, j, 1):
                check = True
            if check:
                print(1)
                print(i + 1, j + 1)
                exit(0)
        if array[i][j] == 2:
            check = False
            if i < len(array) - 4:
                if checkCol(i, j, 2) or checkDiagonal(i, j, 2):
                    check = True
            if checkRow(i, j, 2) or checkDiagonal2(i, j, 2):
                check = True
            if check:
                print(2)
                print(i + 1, j + 1)
                exit(0)
        
print(0)