n = int(input())

number = list(map(int, input().split()))

for i in range(1, n):
    number[i] = max(number[i], number[i - 1] + number[i])
print(max(number))