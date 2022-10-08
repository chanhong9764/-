import math

def solution(s):
    answer = len(s)

    for i in range(1, (len(s) // 2) + 1):
        result = ""
        prevSplit = s[0:i]
        count = 0
        for j in range(0, math.ceil(len(s) / i)):
            split = s[(j*i):(j*i)+i]
            if prevSplit == split:
                count += 1
            else:
                if count != 1:
                    result += str(count)+prevSplit
                else:
                    result += prevSplit
                count = 1
            if (j*i)+i >= len(s):
                if count != 1:
                    result += str(count)+split
                else:
                    result += s[j*i:]
            prevSplit = split
            
        if answer > len(result):
            answer = len(result)
    return answer