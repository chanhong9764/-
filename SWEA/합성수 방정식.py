def check(n):
    for i in range(2, int(n**(1/2)) + 1):
        if n % i == 0:
            return True
    return False

for tc in range(1, int(input()) + 1):
    n = int(input())
    
    for i in range(2, 10000000):
        if check(i):
            if check(i + n):
                print("#", tc, " ", i + n, " ", i, sep="") 
                break