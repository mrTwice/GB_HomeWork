# Задача 14: Требуется вывести все целые степени двойки (т.е. числа вида 2k), не превосходящие числа N.
# 10 -> 1 2 4 8

n = int(input('Введите число N: '))
degree = 0
while 2 ** degree < n:
    print(2 ** degree, end=" ")
    degree += 1