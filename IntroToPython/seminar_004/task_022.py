# Задача 22: Даны два неупорядоченных набора целых чисел (может быть, с повторениями). 
# Выдать без повторений в порядке возрастания все те числа, которые встречаются в обоих наборах.
# Пользователь вводит 2 числа. n - кол-во элементов первого множества. m - кол-во элементов второго множества. 
# Затем пользователь вводит сами элементы множеств.

def is_int(number):
    try:
        int(number)
        return True
    except ValueError:
        return False

def fill_set(our_list, size_of_list):
    while len(our_list) < size_of_list:
        input_from_cl = input('Ведите целое число: ')
        while is_int(input_from_cl) == False:
            input_from_cl = input('Вы ввели не целое число: ')
        our_list.append(input_from_cl)

n = int(input('Введите количество элементов первого набора: '))
m = int(input('Введите количество элементов второго набора: '))
list_of_n = list()
list_of_m = list()

print('Введите элементы первого набора')
fill_set(list_of_n, n)
print('Введите элементы второго набора')
fill_set(list_of_m, m)

set1 = set(list_of_m)
set2 = set(list_of_n)
result = set1 & set2

k = list(result)
k.sort()
print(k)

