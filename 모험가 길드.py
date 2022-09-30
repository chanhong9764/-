n = int(input())
horrors = list(map(int, input().split()))
horrors.sort()

group = 0
member = 0

for horror in horrors:
    member += 1
    if member >= horror:
        group += 1
        member = 0

print(group)
