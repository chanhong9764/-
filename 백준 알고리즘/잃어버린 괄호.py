data = input()

answer = 0
temp = ''

check = False

for i in range(len(data)):
    if data[i] == '-':
        if not check:
            check = True
            temp += '-('
        else:
            temp += ')-('
            check = True
    else:
        temp += data[i]

if check:
    temp += ')'

index = 0
check = False
numberTemp = ''
number = 0

while True:
    if temp[index] == '-':
        check = True
        numberTemp = numberTemp.lstrip("0")
        if numberTemp:
            answer += int(numberTemp)
        numberTemp = ''
    elif temp[index] == ')':
        check = False
        numberTemp = numberTemp.lstrip("0")
        if numberTemp:
            number += int(numberTemp)
        numberTemp = ''
        answer -= number
        number = 0
    else:
        if temp[index] >= '0' and temp[index] <= '9':
            numberTemp += temp[index]
        elif temp[index] == '+':
            numberTemp = numberTemp.lstrip("0")
            if check:
                if numberTemp:
                    number += int(numberTemp)
            else:
                if numberTemp:
                    answer += int(numberTemp)
            numberTemp = ''
            
    index += 1
    if index == len(temp):
        numberTemp = numberTemp.lstrip("0")
        if numberTemp:
            answer += int(numberTemp)
        break
print(answer)