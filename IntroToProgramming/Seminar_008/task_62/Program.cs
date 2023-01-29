// Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4. 
// Например, на выходе получается вот такой массив:
// 01 02 03 04
// 12 13 14 05
// 11 16 15 06
// 10 09 08 07


Console.Clear();
Console.WriteLine("Введите размерность матрицы А");
Console.Write("Input m: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Input n: ");
int n = Convert.ToInt32(Console.ReadLine());

int[,] array = new int[m,n];

    int startStop = 0;
    int columns = 0, rows = 0, quit = n * m ;
    while (true)
    {
        for (int i = columns; i < m - columns; i++) 
            {
                array[rows, i] = startStop++;
            }
        if (startStop == quit) break;

        rows++;

        for (int i = rows; i < n - rows; i++) 
            {
                array[i, m - columns - 1] = startStop++;
            }
       
        for (int i = m - columns - 1; i >= columns; i--)
            {
                array[n - rows, i] = startStop++;
            }
        
        for (int i = n - rows - 1; i >= rows; i--)
            {
                array[i, columns] = startStop++;
            }
            
        columns++;
    }

for (int i =0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
            {
                Console.Write(String.Format("{0,4}", array[i,j]));
            }
        Console.WriteLine();
    }