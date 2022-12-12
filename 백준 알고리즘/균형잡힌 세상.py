value = input()

while value != '.':
    stack = []

    for str in value:
        if str == '(' or str == '[':
            stack.append(str)
        elif str == ')':
            if stack:
                if stack[len(stack) - 1] == '(':
                    stack.pop(len(stack) - 1)
                else:
                    stack.append(str)
            else:
                stack.append(str)
        elif str == ']':
            if stack:
                if stack[len(stack) - 1] == '[':
                    stack.pop(len(stack) - 1)
                else:
                    stack.append(str)
            else:
                stack.append(str)

    if stack:
        print('no')
    else:
        print('yes')
    value = input()