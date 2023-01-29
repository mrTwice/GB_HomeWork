# Задача 2: Найдите сумму цифр трехзначного числа.
# 123 -> 6 (1 + 2 + 3)
# 100 -> 1 (1 + 0 + 0)

string_input = input('Введите трехзначное число: ')
check_the_number = False

while check_the_number == False:
    if string_input.isdigit() == True:
        if len(string_input) <= 4 and 100 <= abs(int(string_input)) <= 999:
            number = int(string_input)
            check_the_number = True
        else:
            string_input = input("Вы ввели не трехзначное число. Введите трехзначное число: ")
    elif string_input[0] == "-" and string_input.lstrip("-").isdigit() == True:
        if len(string_input) <= 4 and 100 <= abs(int(string_input)) <= 999:
            number = int(string_input)
            check_the_number = True
        else:
            string_input = input("Вы ввели не трехзначное число. Введите трехзначное число: ")
    else:
        string_input = input("Вы ввели не трехзначное число. Введите трехзначное число: ")

if string_input.isdigit() == True:
    sum = 0
    for i in range(len(string_input)):
        sum = sum + int(string_input[i])
    print(f'Сумма всех чисел равна: {sum}')
else:
    sum = int(string_input[0]+string_input[1])
    for i in range(2, len(string_input)):
        sum = sum + int(string_input[i])
    print(f'Сумма всех чисел равна: {sum}')
