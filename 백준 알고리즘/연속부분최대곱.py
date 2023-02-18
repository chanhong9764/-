n = int(input())

number = [float(input()) for _ in range(n)]

for i in range(1, n):
    number[i] = max(number[i - 1] * number[i], number[i])
print('%.3f' % max(number))