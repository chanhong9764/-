a, b, c = map(int, input().split())

def power(a, n):
    global c
    
    if n == 0:
        return 1
    
    x = power(a, n // 2)
    temp = x * x
    
    if n % 2 == 0:
        return temp % c
    else:
        return (temp * a) % c

print(power(a, b))