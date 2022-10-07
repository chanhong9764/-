def solution(numbers):
    answer = 0
    for value in range(9):          
        if value+1 not in numbers:  # 1 ~ 9까지 numbers 배열안에 없으면 answer답에 더하기
            answer += value+1
            
    return answer