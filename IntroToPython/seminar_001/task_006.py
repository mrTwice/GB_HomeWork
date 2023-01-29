# Вы пользуетесь общественным транспортом? Вероятно, вы расплачивались за проезд и получали билет с номером. 
# Счастливым билетом называют такой билет с шестизначным номером, где сумма первых трех цифр равна сумме последних трех. 
# Т.е. билет с номером 385916 – счастливый, т.к. 3+8+5=9+1+6. Вам требуется написать программу, которая проверяет счастливость билета.
# 385916 -> yes
# 123456 -> no

string_ticket = input('Введите номер билета для проверки: ')
check = False

while check == False:
    if string_ticket.isdigit() == True:
        if len(string_ticket) == 6:
            check = True
        else:
            string_ticket = input('По условию задачи номер должен быть шестизначным. Введите номер билета для проверки: ')
    else:
        string_ticket = input('Вы ввели не число. Введите шестизначный номер билета: ')

sum_numbers_from_first_part = 0
sum_numbers_from_second_part = 0
for i in range(0,3):
    sum_numbers_from_first_part += int(string_ticket[i])
for i in range(3,6):
    sum_numbers_from_second_part += int(string_ticket[i])


if sum_numbers_from_first_part == sum_numbers_from_second_part:
    print('Ваш билет счастливый')
else:
    print('Повезет в другой раз.')