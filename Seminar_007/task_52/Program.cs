// Задача 52. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.

Console.Clear();

Console.WriteLine("Введите размерность массива m x n");
Console.WriteLine();
Console.Write("Введите m: ");
int m = Convert.ToInt32(Console.ReadLine());

Console.Write("Введите n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int [,] matrix = new int[m,n];

// Заполнение массива случайными целыми числами
for (int i =0; i < m; i++)
    {
        for (int j =0; j < n; j++)
            {
                matrix[i,j] = new Random().Next(0, 10);
                Console.Write(String.Format("{0,7}", matrix[i,j]));
            }
        Console.WriteLine();
    }
Console.WriteLine();


// Поиск среднеарифметического по столбцам
double average = 0;
double columnsSum = 0;

for (int j = 0; j < n; j++)
    {   
        for (int i = 0; i < m; i++)
            {
                columnsSum = columnsSum + matrix[i,j];
            }
        average = columnsSum/m;
        Console.Write(String.Format("{0,7}", average));
        columnsSum = 0;
        average = 0;
    }
