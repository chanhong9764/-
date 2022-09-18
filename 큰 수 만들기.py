def solution(number, k):
    answer = []

    for value in number:
        while k > 0 and answer and answer[-1] < value:
            answer.pop()
            k -=1
        answer.append(value)
    
    return ''.join(answer[:len(answer) - k])