def rotate_2d(list_2d):
    n = len(list_2d) # 행 길이 계산
    m = len(list_2d[0]) # 열 길이 계산
    new = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            new[j][n-i-1] = list_2d[i][j]
    return new

for tc in range(1, 11):
    length = int(input())
    data = []
    cnt = 0
    for _ in range(8):
        data.append(list(input()))
    rotateData = rotate_2d(data)
    for i in range(8):
        # 가로 검사
        for j in range(9-length):
            row = data[i][j:j+length]
            col = rotateData[i][j:j+length]
            
            if row == list(reversed(row)):
                cnt += 1
            if col == list(reversed(col)):
                cnt += 1
    print(f'#{tc} {cnt}')