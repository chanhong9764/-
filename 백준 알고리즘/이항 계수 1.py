n, k = map(int, input().split())

top = 1
bottom = 1

for i in range(n, n - k, -1):
    top *= i
    bottom *= (n - i + 1)
print(top // bottom)