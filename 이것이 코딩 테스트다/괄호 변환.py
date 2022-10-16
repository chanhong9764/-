# u, v로 나누는 함수
def divide(p):
    count_left, count_right = 0, 0
    u, v = "", ""
    temp = ""
    for i in range(len(p)):
        if p[i] == '(':
            count_left += 1
        else:
            count_right += 1
            
        if count_left == count_right:
            u = p[:i+1]
            v = p[i+1:]
            
            if isRight(u):
                temp = u + divide(v)
            else:
                temp = notRight(u, v)
            break
    return temp

# 올바른 괄호 문자열
def isRight(u):
    stack = []
    check = True

    for value in u:
        if value == '(':
            stack.append(value)
        else:
            if stack:
                if value == stack.pop():
                    return False
    if stack:
        return False
    else:
        return True
    
# 올바르지 않은 괄호 문자열
def notRight(u, v):
    temp = '('
    temp += divide(v)
    temp += ')'
    u = u[1:len(u) - 1]
    temp_u = ""
    for value in u:
        if value == '(':
            temp_u += ')'
        else:
            temp_u += '('
    temp += temp_u
    
    return temp
    
        
def solution(p):
    answer = ''
    answer = divide(p)
    return answer