// Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях(индексах).
// [3, 7, 23, 12] -> 19
// [-4, -6, 89, 6] -> 0


void FillArray(int[] randomMassive)
    {
        for (int i = 0; i < randomMassive.Length; i++)
            {
                randomMassive[i] = new Random().Next(0,10);
            }
    }

Console.Clear();

Console.WriteLine();
Console.Write("Введите длинну массива: ");
int number = Convert.ToInt32(Console.ReadLine());

Console.WriteLine();
int[] array = new int[number];
int sum = 0;
FillArray(array);


Console.WriteLine("Наш Массив:");
Console.WriteLine("[" + String.Join(",", array)+ "]");
Console.WriteLine();

for (int i = 0; i < array.Length; i++)
    {
        if (i%2 == 1)
            {
                sum = sum + array[i];
            }
    }

Console.WriteLine($"Сумма чисел на нечетных позициях = {sum}");
