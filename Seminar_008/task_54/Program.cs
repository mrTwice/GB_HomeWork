// // Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.
// // Например, задан массив:
// // 1 4 7 2
// // 5 9 2 3
// // 8 4 2 4
// // В итоге получается вот такой массив:
// // 7 4 2 1
// // 9 5 3 2
// // 8 4 4 2


Console.Clear();
Console.Write("Input n: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input m: ");
int n = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int[,] array = new int[m,n];

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


for (int i = m-1; i >= 0; i--)
    {
        for (int j = n-1; j >= 0; j--)
            {
                int minPosition = j;
                for (int k = j-1; k >=0; k--)
                    {   
                        if(array[i,k] < array[i,minPosition]) minPosition = k;
                    }
                int temp = array[i,j];
                array[i,j] = array[i,minPosition];
                array[i,minPosition] = temp;
            }
        
    }

Console.WriteLine();

for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
            {
                Console.Write(string.Format("{0,4}", array[i,j]));
            }
        Console.WriteLine();
    }

