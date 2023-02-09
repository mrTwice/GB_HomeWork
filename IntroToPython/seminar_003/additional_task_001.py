# Задана последовательность натуральных чисел, завершающаяся числом 0. Требуется определить значение второго по величине элемента в этой последовательности, 
# то есть элемента, который будет наибольшим, если из последовательности удалить наибольший элемент.
# input:	1 7 9 0	7
# output : 7
# input:	1 2 3 4 5 6 7 0 8 9 10
# output: 6


numbers = [1, 7, 11, 9, 22, 44, 12, 7, 0, 7]
part_of_numbers = numbers[:numbers.index(0)]
part_of_numbers.sort()
print(part_of_numbers[-2])

n = int(input())
max1 = n
max2 = 0
while n != 0:
    n = int(input())
    if max1 < n:
        max2 = max1
        max1 = n
    elif max2 < n:
        max2 = n
print(max2)