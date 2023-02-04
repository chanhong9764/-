n, m = map(int, input().split())

if n - m < n // 2:
    m = n - m

bottom = 1
top = 1

for i in range(n, n - m, - 1):
    top *= i

for i in range(1, m + 1):
    bottom *= i

print(top // bottom)