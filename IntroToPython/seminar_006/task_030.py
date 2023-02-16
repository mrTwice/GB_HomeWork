# Задача 30: Заполните массив элементами арифметической прогрессии. Её первый элемент, разность и количество элементов нужно ввести с клавиатуры. 
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d. 
# Каждое число вводится с новой строки.
# Ввод: 7 2 5
# Вывод: 7 9 11 13 15

start_int, step, cnt_n = input('Введите начальные данные: ').split(' ')
arithmetic_progression = [start_int]
while len(arithmetic_progression) < int(cnt_n):
    arithmetic_progression.append(int(arithmetic_progression[-1]) + int(step))
print(arithmetic_progression)