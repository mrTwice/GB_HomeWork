// Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
// Например, даны 2 матрицы:
// 2 4 | 3 4
// 3 2 | 3 3
// Результирующая матрица будет:
// 18 20
// 15 18

// matrixA[0,0] * matrixB[0,0] + matrixA[0,1] * matrixB[1,0] | matrixA[0,0] * matrixB[0,1] + matrixA[0,1] * matrixB[1,1];
// matrixA[1,0] * matrixB[0,0] + matrixA[1,1] * matrixB[1,0] | matrixA[1,0] * matrixB[0,1] + matrixA[1,1] * matrixB[1,1];
void FillArray (int [,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    matrix[i,j] = new Random().Next(0,10);
                }
        }
}

void PrintMatrix(int[,] matrix)
{
    for (int i =0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    Console.Write(string.Format("{0,4}", matrix[i,j]));
                }
            Console.WriteLine();
        }
}

void MultiplyMatrix(int [,] firstMatrix, int [,] secondMatrix, int[,] multiplicationMatrix)
{
    for (int i = 0; i < firstMatrix.GetLength(0); i++)
        {
            for (int j = 0; j < secondMatrix.GetLength(1); j++)
            {
                for (int k = 0; k < secondMatrix.GetLength(0); k++)
                {
                    multiplicationMatrix[i, j] += firstMatrix[i, k] * secondMatrix[k, j];
                }
            }
        }
}

Console.Clear();
Console.WriteLine("Введите размерность матрицы А");
Console.Write("Input m: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

Console.WriteLine("Введите размерность матрицы B");
Console.Write("Input l: ");
int l = Convert.ToInt32(Console.ReadLine());
Console.Write("Input v: ");
int v = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

if (m != v) 
    {
        Console.WriteLine("Количество столбцов матрицы А должно совпадать с количеством строк матрицы В");
    }

int [,] matrixA = new int[m, n];
int [,] matrixB = new int[l,v];
int [,] resultMatrix = new int[n,l];



FillArray(matrixA);
FillArray(matrixB);
MultiplyMatrix(matrixA,  matrixB, resultMatrix);
PrintMatrix(resultMatrix);