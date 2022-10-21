def solution(N, stages):
    answer = []
    percentage = []
    count = [0] * (N + 1)
    
    for value in stages:
        count[value - 1] += 1
    
    for i in range(N):
        people = 0
        for j in range(i, N + 1):
            people += count[j]
        if people != 0:
            percentage.append((i, count[i] / people))
        else:
            percentage.append((i, 0))
    percentage.sort(key = lambda x: -x[1])
    
    for value in percentage:
        answer.append(value[0] + 1)
    return answer