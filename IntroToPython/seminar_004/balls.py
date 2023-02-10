from collections import Counter
bolls = [5,2,1,1,3,3,3,1,1,2,2] # Последовательность шаров
bolls_on_start = (len(bolls)) # Определение начального количества шаров
dictionary = Counter(bolls) # Наполнение словаря, в коротом ключ - цвет, значение ключа - количество шаров данного цвета
iteration = 0 
while iteration < len(dictionary.keys()): # Количество итерраций не должно превышать количество уникальных цветов в последовательности
    for key, values in dictionary.items():
        if int (values) >= 3:  # Если количество шаров любого из цветов больше ли равно указанному, заходим в цикл
            indexes = [] # список для хранения индексов шаров одного цвета
            for i in range(0,len(bolls)):
                if int(key) == int(bolls[i]): # Если увет шара из dictionary соответствует таковому в последовательности, добавляем индекс шара из последовательности в списов indexes
                    indexes.append(i)
            fire_line = set() # Множество для хранения индексов
            idx = 0
            while idx < len(indexes) - 1:
                if indexes[idx] == indexes[idx + 1] -1: # Если текущий индекс на единицу меньше следующего, значит они идут последовательно, добавляем оба во мнодество
                    fire_line.add(indexes[idx])
                    fire_line.add(indexes[idx] + 1)
                else: break # Прервываем процесс, если встретили шар другого цвета
                idx += 1
            if len(fire_line) < 3: fire_line = {} # Если количество шаров меньше заданного, очищаем множество
            fire_line = list(fire_line) # Преобразование в списов
            fire_line.reverse() # Разворот списка индексов последовательности шаров
            for i in fire_line:
                bolls.pop(i) # Последовательное удаление шаров из начального списка, по их индексам
    if len(bolls) < 3: # Если длина списка меньше указанной, выходим 
        break
    iteration += 1 
print(f'Шаров сгорело: {bolls_on_start - len(bolls)}') # Вывод итога