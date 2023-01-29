# Задача 8: Требуется определить, можно ли от шоколадки размером n × m долек отломить k долек, 
# если разрешается сделать один разлом по прямой между дольками (то есть разломить шоколадку на два прямоугольника).
# 3 2 4 -> yes
# 3 2 1 -> no

def Check_Input(number):
    check = False
    while check == False:
        if number.isdigit() == True:
            check = True
        else:
            number = input('Введите целое положительное число: ')
    return number

string_m = input('Введите колиeство долек по первой стороне шоколадки: ')
m = int(Check_Input(string_m))
string_n = input('Введите количeство долек по второй стороне шоколадки: ')
n = int(Check_Input(string_n))
string_k = input('Сколько долек выхотите отломить: ')
k = int(Check_Input(string_k))

if k < n * m and k % n == 0 or k % m == 0:
    print (f'Да, {k} долек можно отломить за раз.')
else:
    print(f'Нет, {k} долек нельзя отломить одним отломом.')

