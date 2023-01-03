import sys
sys.setrecursionlimit(10**7)

n, r, c = map(int, input().split())

count = 0

def recursive(x, y, n):
    global count
    # x,y가 r과 c의 범위에 없을 경우 
    if not (x <= r < x + n and y <= c < y + n):
        count += n**2
        return 
    
    if x == r and y == c:
        print(count)
        return
        
    if n > 1:
        n = n // 2
        recursive(x, y, n)
        recursive(x, y + n, n)
        recursive(x + n, y, n)
        recursive(x + n, y + n, n)
    else:
        count += 1
    
recursive(0, 0, 2**n)