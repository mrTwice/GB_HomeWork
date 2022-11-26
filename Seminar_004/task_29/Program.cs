// Задача 29: Напишите программу, которая задаёт массив из 8 элементов и выводит их на экран.
// 1, 2, 5, 7, 19 -> [1, 2, 5, 7, 19]
// 6, 1, 33 -> [6, 1, 33]

Console.Clear();
Console.Write("Введите размер массива: ");
int arraySize = Convert.ToInt32(Console.ReadLine());
int[] array = new int[arraySize];
for (int i = 0; i < array.Length; i++)
    {
        Console.Clear();
        Console.Write($"Введите элемент № {i}: ");
        array[i] = Convert.ToInt32(Console.ReadLine());
    }
Console.WriteLine(string.Join(", ", array));