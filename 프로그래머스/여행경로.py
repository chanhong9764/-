import sys
sys.setrecursionlimit(10**7)

def solution(tickets):
    answer = ['ICN']
    array = {}
    
    for departure, arrival in tickets:
        if departure in array:
            array[departure].append([arrival, False])
        else:
            array[departure] = [[arrival, False]]
            if arrival not in array:
                array[arrival] = []
    
    for key in array.keys():
        array[key].sort(key=lambda x : x[0])

    def dfs(start):
        for value in array[start]:
            if value[1] == False:
                answer.append(value[0])
                dfs(value[0])

        
    dfs('ICN')
    return answer

print(solution(input()))