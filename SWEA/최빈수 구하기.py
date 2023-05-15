for _ in range(int(input())):
    tc = int(input())
    
    answer = [0] * 101
    
    numbers = list(map(int, input().split()))
    
    for number in numbers:
        answer[number] += 1
    
    maxValue = max(answer)
    answerValue = 0
    for i in range(101):
        if answer[i] == maxValue and answerValue < i:
            answerValue = i
            
    print("#", tc, " ", answerValue, sep="")