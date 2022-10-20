from itertools import combinations
import copy

n = int(input())

teacher = []
road = []
map = []

isAvoid = False
check = False

for r in range(n):
    data = (list(input().split()))
    map.append(data)
    for i in range(n):
        if data[i] == 'T':
            teacher.append((r, i))
        elif data[i] == 'X':
            road.append((r, i))

obstacles = list(combinations(road, 3))

def up(installMap, x, y):
    global check
    nx = x - 1
    if nx >= 0:
        if installMap[nx][y] == 'S':
            check = True
        elif installMap[nx][y] == 'X':
            up(installMap, nx, y)
            
def down(installMap, x, y):
    global check
    nx = x + 1
    if nx < n:
        if installMap[nx][y] == 'S':
            check = True
        elif installMap[nx][y] == 'X':
            down(installMap, nx, y)
            
def left(installMap, x, y):
    global check
    ny = y - 1
    if ny >= 0:
        if installMap[x][ny] == 'S':
            check = True
        elif installMap[x][ny] == 'X':
            left(installMap, x, ny)
            
def right(installMap, x, y):
    global check
    ny = y + 1
    if ny < n:
        if installMap[x][ny] == 'S':
            check = True
        elif installMap[x][ny] == 'X':
            right(installMap, x, ny)
            

def isAvoiding(installMap):
    global check
    check = False
    for x, y in teacher:
        up(installMap, x, y)
        down(installMap, x, y)
        left(installMap, x, y)
        right(installMap, x, y)
        
    return check

for obstacle in obstacles:
    mapTemp = copy.deepcopy(map)
    for x, y in obstacle:
        mapTemp[x][y] = 'O'
    # 확인 함수
    if not isAvoiding(mapTemp):
        isAvoid = True
        break
    
if isAvoid:
    print("YES")
else:
    print("NO")