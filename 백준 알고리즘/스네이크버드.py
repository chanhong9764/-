n, l = map(int, input().split())

length = list(map(int, input().split()))

length.sort()

for value in length:
    if value <= l:
        l += 1
print(l)