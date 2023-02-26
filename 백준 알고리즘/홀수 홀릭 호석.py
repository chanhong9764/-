n = int(input())
cnt = 0
max_v, min_v = 0, int(1e9)

def Odd(start, cnt):
    global max_v, min_v
    for value in start:
        if int(value) % 2 == 1:
            cnt += 1
            
    if len(start) == 1:
        max_v = max(max_v, cnt)
        min_v = min(min_v, cnt)
        return
    elif len(start) == 2:
        secondString = int(start[0]) + int(start[1])
        Odd(str(secondString), cnt)
    else:
        for i in range(len(start) - 2):
            for j in range(i+1, len(start)-1):
                a = start[:i+1]
                b = start[i+1: j+1]
                c = start[j+1:]
                temp = str(int(a) + int(b) + int(c))
                Odd(temp, cnt)
        
Odd(str(n), cnt)
print(min_v, max_v)