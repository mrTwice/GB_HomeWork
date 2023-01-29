// Задача 59. Задайте двумерный массив из целых чисел. Напишите программу, которая удалит строку и столбец, на пересечении которых расположен наименьший элемент массива.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// 5 2 6 7
// Наименьший элемент - 1, на выходе получим 
// следующий массив:
// 9 2 3
// 4 2 4
// 2 6 7


void FillArray (int [,] array)
{
     for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    array[i,j] = new Random().Next(0,100);
                }
        }
}

void PrintArray (int [,] array)
{
     for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    Console.Write(String.Format("{0,4}", array[i,j]));
                }
            Console.WriteLine();
        }
}

void FindIndexMinimumElement (int [,] array, out int indexRow, out int indexColumn)
{
    int min = array[0,0];
    indexColumn = 0;
    indexRow = 0;
    for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    if (array[i,j] < min)
                        {
                            min = array[i,j];
                            indexRow = i;
                            indexColumn = j;
                        }
                }
        }
}

void ResizeArray(int[,] array, int rowIndexminimum, int columnIndexMinimum)
{
    int cuti=0, cutj =0;
    int[,] arrayR = new int [array.GetLength(0)-1, array.GetLength(1)-1];
    for (int i = 0; i < array.GetLength(0)-1; i++)
        {
            if(i < rowIndexminimum)
                {
                    cuti=i;
                }
            else
                {
                    cuti = i+1;
                }
        
            for (int j = 0; j < array.GetLength(1)-1; j++)
                {
                    if (j < columnIndexMinimum)
                        {
                            cutj=j;
                        }
                    else
                        {
                            cutj= j+1;
                        }
                    arrayR[i,j] = array[cuti,cutj];
                    Console.Write(String.Format("{0,4}", arrayR[i,j]));
                }
            Console.WriteLine();
        }
}

Console.Clear();
Console.WriteLine("Введите размерность матрицы А");
Console.Write("Input m: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int[,] arrayF = new int[m,n];
//int[,] arrayR = new int[m-1,n-1];
int rowMinimum = 0;
int columnMinimum = 0;

FillArray(arrayF);
PrintArray(arrayF);
FindIndexMinimumElement(arrayF, out rowMinimum, out columnMinimum);
Console.WriteLine();
Console.WriteLine($"Индекс минимального элемента в исходном массива ({rowMinimum}, {columnMinimum})");
Console.WriteLine();
ResizeArray(arrayF, rowMinimum, columnMinimum);