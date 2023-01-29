// Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.
// [345, 897, 568, 234] -> 2

int[] FillArray (int size)
    {
        int[] massive = new int[size];
        for (int i = 0; i < massive.Length; i++)
            {
                massive[i] = new Random().Next(100,1000);
            }
        return massive;
    }

Console.Clear();
Console.Write("Введите длинну массива: ");
int arraySize = Convert.ToInt32(Console.ReadLine());

bool check = false;
int count = 0;

int[] array = FillArray(arraySize);

Console.WriteLine();
Console.WriteLine("Наш Массив: [" + String.Join(",", array)+ "]");

for (int i = 0; i < array.Length; i++)
    {
        if (array[i]%2 == 0)
            {
                check = true;
                count++;
            }
    }

if (check == true)
    {
        Console.WriteLine();
        Console.WriteLine($"    Четных числе в нем: {count}");
        Console.WriteLine();
    }
else
    {
        Console.WriteLine();
        Console.WriteLine($"В массиве четных чисел нет");
        Console.WriteLine();
    }