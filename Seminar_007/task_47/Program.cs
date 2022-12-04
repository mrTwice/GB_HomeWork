// Задача 47. Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.
// m = 3, n = 4.
// 0,5 7 -2 -0,2
// 1 -3,3 8 -9,9
// 8 7,8 -7,1 9

Console.Clear();

Console.WriteLine("Введите размерность массива m x n");
Console.WriteLine();
Console.Write("Введите m: ");
int m = Convert.ToInt32(Console.ReadLine());

Console.Write("Введите n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();
double [,] matrix = new double[m,n];

for (int i =0; i < m; i++)
    {
        for (int j =0; j < n; j++)
            {
                int integerPart = new Random().Next(-100, 101);
                double doublePart = new Random().NextDouble();
                matrix[i,j] = integerPart + Math.Round(doublePart, 2);
                Console.Write(String.Format("{0,10}", matrix[i,j]));

            }
        Console.WriteLine();
    }
Console.WriteLine();