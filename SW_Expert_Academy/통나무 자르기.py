T = int(input())

for tc in range(1, T+1):
    
    N = int(input())
    res = 'Alice'
    if N % 2 != 0:
        res = 'Bob'

    print(f'#{tc} {res}')