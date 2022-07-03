def solution(lottos, win_nums):
    answer = []
    count = [0,0]
    dic = { 6:1, 5:2, 4:3, 3:4, 2:5 }
    
    for lotto in lottos:
        if lotto in win_nums:
            count[1] += 1
            count[0] += 1
        if lotto == 0:
            count[0] += 1

    for value in count:
        answer.append(dic.get(value, 6))
        
    return answer