n = int(input())

array = []

for _ in range(n):
    array.append(list(map(int, input().split())))

array = [[0] + line + [0] for line in array]

for i in range(1, n):
    for j in range(1, i + 2):
        array[i][j] += max(array[i - 1][j - 1], array[i - 1][j])

print(max(array[-1]))