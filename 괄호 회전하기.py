from collections import deque

def solution(s):
    answer = 0
    s = deque(s)
    open = ['(', '[', '{']
    for i in range(len(s)):
        check = False
        s.rotate(-1)
        stack = []
        for value in s:
            if value in open:
                stack.append(value)
            else:
                if len(stack) > 0:
                    top = stack.pop()
                    if (top == '(' and value == ')') or (top == '[' and value == ']') or (top == '{' and value == '}') :
                        check = True
                else:
                    check = False
                    break;
                    
        if len(stack) > 0:
            check = False
        if check:
            answer = answer + 1
            
    return answer