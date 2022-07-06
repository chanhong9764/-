def solution(sizes):
    answer = 0
    
    for item in sizes:
        if item[1] > item[0]:
            temp = item[0]
            item[0] = item[1]
            item[1] = temp

    leftMax = max(t[0] for t in sizes)
    rightMax = max(t[1] for t in sizes)
    
    answer = leftMax * rightMax
    return answer


# 문제에서 가로로 눕혀 수납을 한다는 글에서 힌트를 얻어 명함의 가로 세로 중 큰 값을 왼쪽으로 몰고 오른쪽은 작은 값으로 몰았다. 그리고 왼쪽, 오른쪽에서 가장 큰 값을 뽑아 서로 곱하였더니 답이 나와 알고리즘을 위와 같은 방식으로 구현하였다. 