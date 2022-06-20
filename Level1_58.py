def solution(s):
    answer = ""
    dic = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9',
    }
    word = ''
    for value in s:
        word += value
        if(ord(value) >= 48 and ord(value) <= 57): # 정수면 answer 추가
            answer+=value
            word=''
        else:
            if(dic.get(word)):                     # word가 dictionary에 key 값으로 있으면 value 값 추가
                answer += (dic.get(word))
                word=''
    answer = int(answer)
    return answer