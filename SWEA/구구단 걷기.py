def getDivisor(n):
    data = []
    
    for i in range(1, int(n**(1/2)) + 1):
        if n % i == 0:
            data.append((i, n // i))

    return data
        

for tc in range(1, int(input()) + 1):
    n = int(input())
    
    answer = []
    
    for x, y in getDivisor(n):
        answer.append((x - 1) + (y - 1))
    
    print("#", tc, " ", min(answer), sep="")