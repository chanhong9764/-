for tc in range(1, int(input()) + 1):
    ground = input()
    ground_l = len(ground)
    answer = 0
    
    for i in range(ground_l):
        if ground[i] == '.' or ground[i] == '|':
            continue
        if ground[i] == '(' and i != ground_l:
            if ground[i + 1] == '|' or ground[i + 1] == '.':
                answer += 1
            else:
                answer += 1
        else:
            if ground[i] == ')' and i != 0:
                if ground[i - 1] == '|' or ground[i - 1] == '.':
                    answer += 1
    print("#",tc, " ", answer, sep='')