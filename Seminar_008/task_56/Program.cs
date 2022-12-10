// Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// 5 2 6 7
// Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов: 1 строка

Console.Clear();
Console.Write("Input n: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input m: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int[,] array = new int[m,n];
int [] temp = new int[m];
int sum = 0;

Console.WriteLine();


for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
            {
                array[i,j] = new Random().Next(0,10);
                Console.Write(string.Format("{0,4}", array[i,j]));
            }
        Console.WriteLine();
    }


for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
            {
                sum = sum + array[i,j];
            }
        temp[i] = sum;
        sum = 0;
        
    }
Console.WriteLine();

int indexForMinimum = 0;
int min = temp[0];
for (int i = 0; i < m; i++)
    {
        if (temp[i] < min)
            {
                min = temp[i];
                indexForMinimum = i;
            }
        Console.WriteLine(string.Format("{0,4}", temp[i]));
    }

Console.WriteLine();
Console.WriteLine($"В строке под номером {indexForMinimum+1} сумма чисел минимальна");