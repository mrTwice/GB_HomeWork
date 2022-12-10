// Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
// Массив размером 2 x 2 x 2
// 66(0,0,0) 25(0,1,0)
// 34(1,0,0) 41(1,1,0)
// 27(0,0,1) 90(0,1,1)
// 26(1,0,1) 55(1,1,1)


void FillArray (int [,,] array)
{
     for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    for (int k = 0; k < array.GetLength(2); k++)
                        {
                            int temp = new Random().Next(10,100);
                            while (FindRepeat(array, temp) == false)
                                {
                                    temp = new Random().Next(10,100);
                                }
                            array[i,j,k] = temp;
                            
                        }
                    
                }
        }
}


void PrintArray (int [,,] array)
{
    for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    for (int k = 0; k < array.GetLength(2); k++)
                        {
                            Console.Write($" {array[i,j,k]}  ({i},{j},{k})");
                        }
                    Console.WriteLine();
                }
        }
}
// ({i},{j},{k})");
bool FindRepeat (int [,,] array, int dimension)
{
    for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
                {
                    for (int k = 0; k < array.GetLength(2); k++)
                        {
                            if (dimension == array[i,j,k]) return false;
                        }
                }
        }
    return true;
}

Console.Clear();
Console.WriteLine("Введите размерность матрицы А");
Console.Write("Input m: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input n: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.Write("Input l: ");
int l = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int[,,] coub = new int[m,n,l];

FillArray(coub);
PrintArray(coub);