# balls = [5, 6, 2, 1, 6, 1, 3, 3, 3, 1, 1, 2, 2, 5, 5] # Последовательность шаров 1
# balls = [5, 2, 1, 1, 3, 3, 3, 1, 1, 2, 2, 5, 5] # Последовательность шаров 2
# balls = [5, 2, 1, 1, 3, 3, 3, 1, 1, 2, 2] # Последовательность шаров 3

from collections import Counter
balls = [5, 2, 1, 1, 3, 3, 3, 1, 1, 2, 2] # Последовательность шаров 3
balls_on_start = (len(balls)) # Определение начального количества шаров
dictionary = Counter(balls) # Наполнение словаря, в коротом ключ - цвет, значение ключа - количество шаров данного цвета
for iterration in range(0, len([i for i in dictionary.values() if int(i) > 2])):
    for key, values in dictionary.items():
        if int(values) > 2:  # Если количество шаров любого из цветов больше ли равно указанному, заходим в цикл
            indexes = [] # список для хранения индексов шаров одного цвета
            for i in range(0,len(balls)):
                if key == balls[i]:
                    indexes.append(i)
            fire_line = set() # Множество для хранения индексов, которые должны сгореть
            for idx in range(1, len(indexes)):
                if indexes[idx] == indexes[idx - 1] +1: # Если текущий индекс на единицу больше следующего, значит они идут последовательно, добавляем оба во множество
                    fire_line.add(indexes[idx])
                    fire_line.add(indexes[idx] - 1)
            if len(fire_line) > 2: 
                fire_line = list(fire_line) # Преобразование в список
                fire_line.sort(reverse=True) # Разворот списка индексов последовательности шаров
                for i in fire_line:
                    balls.pop(i) # Последовательное удаление шаров из начального списка, по их индексам
                    print(balls)
            else: fire_line = {} # Если количество шаров меньше заданного, очищаем множество
print(f'Шаров сгорело: {balls_on_start - len(balls)}') # Вывод итога
