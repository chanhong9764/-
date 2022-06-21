import math

def solution(left, right):
    answer = 0
    for value in range(left, right+1):                  # left ~ right까지
        totalArray = []                                 # 최종 약수 배열
        divideArray = []                                # 나누는 수 배열
        for divide in range((int)(math.sqrt(value))):   # 1부터 나눠지는 수의 제곱근까지
            if value % (divide+1) == 0:                 # 0으로 나누어 떨어지면 약수
                divideArray.append(divide+1)
                totalArray.append(divide+1)
        for divide in divideArray:                      # 0으로 나누어 떨어지게 만든 수로 다시 N을 나누면 약수가 나옴 
            totalArray.append(value//divide)
        countArray = set(totalArray)                    # 중복이 존재하기 떄문에 SET를 이용하여 중복 제거
        if len(countArray) % 2 == 0:                    # 약수의 개수가 짝수면 더하기 홀수면 빼기
            answer += value
        else:
            answer -= value
            
    return answer

# 알고리즘 참고 블로그 - https://kbw1101.tistory.com/32