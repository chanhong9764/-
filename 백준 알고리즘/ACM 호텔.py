tc = int(input())

for _ in range(tc):
    h, w, c = map(int, input().split())
    
    room = c // h
    floor = c % h
    
    if floor == 0:
        floor = h
    else:
        room += 1
        
    if len(str(room)) == 1:
        room = '0' + str(room)
        
    print(str(floor)+str(room))