while True:
    number = int(input())
    
    if number == 0:
        break
    number = str(number)
    if number == "".join(reversed(number)):
        print('yes')
    else:
        print('no')