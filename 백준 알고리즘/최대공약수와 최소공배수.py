n, m = map(int, input().split())

def gcd(n, m):
    while m != 0:
       t = n % m
       n, m = m, t
    return abs(n)

gcdValue = gcd(n, m)

print(gcdValue)
print((n * m) // gcdValue)

# 유클리드 호제법 알고리즘