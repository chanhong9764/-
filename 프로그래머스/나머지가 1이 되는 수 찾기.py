def solution(n):
    answer = 0 
    for i in range(2, n):
        if int(n-1)%i == 0: 
            answer = i
            break;
        
    return answer

# 단순히 for문을 돌리면 타임아웃이 날 거 같아 규칙을 찾던 중 n-1의 가장 작은 약수를 구하면 답이 나오는 규칙을 찾아서 해당 알고리즘으로 진행