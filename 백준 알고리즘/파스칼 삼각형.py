r, c, w = map(int, input().split())

triangle = [[0] * 31 for _ in range(31)]
triangle[1][1] = 1

for i in range(2, 30):
    for j in range(1, i + 1):
        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]

for i in range(r + 1, r + w):
    for j in range(c, i - r + c + 1):
        if j == c:
            triangle[i][j] += triangle[i - 1][c + i - r - 1]
        else:
            triangle[i][j] += triangle[i][j - 1]

print(triangle[r + w - 1][c + w - 1])