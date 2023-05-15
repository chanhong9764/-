t = int(input())

def check(data):
    for i in range(9):
        checkRow = []
        checkCol = []
        for j in range(9):
            if checkRow:
                if data[i][j] in checkRow:
                    return 0
            if checkCol:
                if data[j][i] in checkCol:
                    return 0
            checkRow.append(data[i][j])
            checkCol.append(data[j][i])
            
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            checkBox = []
            for k in range(3):
                for l in range(3):
                    if checkBox:
                        if data[i+k][j+l] in checkBox:
                            return 0
                    checkBox.append(data[i+k][j+l])
    return 1

for tc in range(1, t + 1):
    data = [list(map(int, input().split(' '))) for _ in range(9)]
    print('#', tc,  " ", check(data), sep="")