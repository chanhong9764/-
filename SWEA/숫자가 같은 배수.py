from itertools import permutations
 
T = int(input())
 
for tc in range(1, T + 1):
    n = input()
    num = int(n)
    length = len(n)
    num_list = []
    isValid =  False
 
    if len(n) == 1:
        print('#%d impossible' % tc)
        continue
 
    for i in permutations(n, length):
        temp = ''
        for j in i:
            temp += j
        if temp[0] != '0':
            if int(temp) not in num_list:
                num_list.append(int(temp))
 
    for i in range(1, len(num_list)):
        if num_list[i] % num_list[0] == 0:
            isValid = True
            break
 
    if isValid:
        print('#%d possible' % tc)
    else:
        print('#%d impossible' % tc)