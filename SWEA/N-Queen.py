# 이전까지 열에서 가능한지 검사하는 함수
def pos(k):
    # 같은 행에 존재하거나 대각선에 존재하면 False
    for i in range(k):
        if arr[k] == arr[i] or abs(arr[k] - arr[i]) == k - i:
            return False
    return True
 
# 가능한 퀸의 위치 개수를 찾는 함수
def queen(k):
    global result
    # 가능하면 결과값 +1
    if k == N:
        result += 1
    else:
        # 각 열마다 0 ~ N-1 행에 퀸을 배치
        for i in range(N):
            arr[k] = i
            # 가능한 경우 진행
            if pos(k):
                queen(k+1)
 
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    result = 0
    # 각 열에 어느 행에 퀸이 존재하는지 표시할 배열
    arr = [0 for _ in range(N)]
    queen(0)
    print('#{} {}'.format(tc, result))