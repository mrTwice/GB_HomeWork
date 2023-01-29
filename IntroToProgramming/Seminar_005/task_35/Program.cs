// Задача 35: Задайте одномерный массив из 123 случайных чисел. Найдите количество элементов массива, значения которых лежат в отрезке [10,99]. 
// Пример для массива из 5, а не 123 элементов. В своём решении сделайте для 123
// [5, 18, 123, 6, 2] -> 1
// [1, 2, 3, 6, 2] -> 0
// [ 10, 11, 12, 13, 14 ] -> 5


int[] FillArray (int size)
    {
        int[] massive = new int[size];
        for (int i = 0; i < massive.Length; i++)
            {
                massive[i] = new Random().Next(0,1000);
            }
        return massive;
    }

Console.Clear();

Console.WriteLine();
Console.Write("Введите длинну массива: ");
int number = Convert.ToInt32(Console.ReadLine());

Console.WriteLine();

 Console.Write("Введите значения начала интервела для поиска: ");
int start = Convert.ToInt32(Console.ReadLine());
Console.Write("Введите значения конеца интервала для поиска: ");
int stop = Convert.ToInt32(Console.ReadLine());
bool check = false;
int count =0;

int[] array = FillArray(number);


Console.WriteLine("Наш Массив:");

Console.WriteLine("[" + String.Join(",", array)+ "]");
Console.WriteLine();

for (int i = 0; i < array.Length; i++)
    {
        if (array[i] >=start && array[i] <= stop)
            {
                check = true;
                count++;
            }
    }

if (check == true)
    {
        Console.WriteLine($"{count} чесел лежат в заданном отрезке.");
    }
else
    {
        Console.WriteLine($"В заданном отрезче числе не втсречается");
    }