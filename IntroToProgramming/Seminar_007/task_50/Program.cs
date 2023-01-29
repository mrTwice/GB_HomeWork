// Задача 50. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// 17 -> такого числа в массиве нет

Console.Clear();

Console.WriteLine("Введите размерность массива m x n");
Console.WriteLine();
Console.Write("Введите m: ");
int m = Convert.ToInt32(Console.ReadLine());

Console.Write("Введите n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

Console.WriteLine("Для просмотра значения элемента массива, введите номер позиции: ");
Console.Write("Введите номер строки: ");
int positionRow = Convert.ToInt32(Console.ReadLine());

Console.Write("Введите номер столбца: ");
int positionColumns = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

double [,] matrix = new double[m,n];

// Заполнение массива случайными вещественными числами
for (int i =0; i < m; i++)
    {
        for (int j =0; j < n; j++)
            {
                int integerPart = new Random().Next(-100, 101);
                double doublePart = new Random().NextDouble();
                matrix[i,j] = integerPart + Math.Round(doublePart, 2);
            }
    }
Console.WriteLine();

// Проверка существования запрашиваемого элемента массива, вывод указанного
if (positionRow > m-1 && positionColumns > n-1) 
    {
        Console.WriteLine("Такого элемента не существует");
    }
else Console.WriteLine(matrix[positionRow-1,positionColumns-1]);

Console.WriteLine();

//  Вывод массива в консоль с выделение запрашиваемого эллемента
bool showArray = false;
Console.Write("Ведите 'Да', если хотите вывести массив на экран: ");
string printArray = Console.ReadLine();

if (printArray.ToLower() == "да")
    {
                
        for (int i =0; i < m; i++)
            {
                for (int j =0; j < n; j++)
                    {   if ( i == positionRow-1 & j == positionColumns-1)
                            {
                                Console.BackgroundColor = ConsoleColor.White;
                                Console.ForegroundColor = ConsoleColor.Red;
                            }
                        else Console.ResetColor();
                        Console.Write(String.Format("{0,10}", matrix[i,j]));
                    }
                Console.WriteLine();
            }
    }
Console.WriteLine();