n = int(input())

array = [[0] * (n + 1) for _ in range(n + 1)]
people = []
position = [[0, 0] for _ in range(n * n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def isBlank(blankArray):  
    blank = []
    maxCount = 0
    for x, y in blankArray:
        count = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx <= 0 or nx >= n + 1 or ny <= 0 or ny >= n + 1:
                continue
            if array[nx][ny] != 0:
                continue
            count += 1

        if maxCount == count:
            blank.append([x, y])
        elif maxCount < count:
            blank.clear()
            blank.append([x, y])
            maxCount = count

    return blank

def likePerson(idx):
    blank = []
    maxCount = 0
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if array[i][j] == 0:
                count = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    
                    if nx <= 0 or nx >= n + 1 or ny <= 0 or ny >= n + 1:
                        continue

                    if array[nx][ny] in people[idx]:
                        count += 1
                        
                if maxCount == count:
                    blank.append([i, j])
                elif maxCount < count:
                    blank.clear()
                    blank.append([i, j])
                    maxCount = count
                
    return blank

def satisfaction(idx):
    x, y = position[idx]
    count = 0
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx <= 0 or nx >= n + 1 or ny <= 0 or ny >= n + 1:
            continue
    
        if array[nx][ny] in people[idx]:
            count += 1
    if count == 0:
        return 0
    elif count == 1:
        return 1
    elif count == 2:
        return 10
    elif count == 3:
        return 100
    else:
        return 1000
    
for _ in range(n * n):
    people.append(list(map(int, input().split())))

for i in range(n * n):
    likePeople = likePerson(i)
 
    if len(likePeople) == 1:
        x, y = likePeople[0]
        array[x][y] = people[i][0]
        position[i] = [x, y]
    else:
        nearBlank = isBlank(likePeople)
        if len(nearBlank) == 1:
            x, y = nearBlank[0]
            array[x][y] = people[i][0]
            position[i] = [x, y]
        else:
            nearBlank.sort(key=lambda x: (x[0], x[1]))
            x, y = nearBlank[0]
            array[x][y] = people[i][0]
            position[i] = [x, y]
            
answer = 0
for i in range(n * n):
    answer += satisfaction(i)
    
print(answer)