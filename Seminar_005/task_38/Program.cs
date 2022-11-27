// Задача 38: Задайте массив вещественных(тип double) чисел. Найдите разницу между максимальным и минимальным элементов массива.
// [3 7 22 2 78] -> 76

void FillArray (double[] randomMassive)
    {
        int intPart;
        double doublePart;
        for (int i = 0; i < randomMassive.Length; i++)
            {
                intPart = new Random().Next(0,100);
                doublePart = new Random().NextDouble();
                randomMassive[i] = intPart + Math.Round(doublePart, 2);
            }
    }

void MinMax (double[] minMaxFindArray, out double min, out double max)
    {
        min = minMaxFindArray[0];
        max = minMaxFindArray[1];
        double temp= max;


        if (max < min)
        {
            temp = min;
            min = max;
            max = temp;
        }
        for (int i = 2; i < minMaxFindArray.Length; i++)
            {
                if (min > minMaxFindArray[i])
                    {
                        min = minMaxFindArray[i];
                    }
                else
                    {
                        if (max < minMaxFindArray[i])
                            {
                                max = minMaxFindArray[i];
                            }
                    }

            }
    }

Console.Clear();
Console.Write("Введите длинну массива: ");
int arraySize = Convert.ToInt32(Console.ReadLine());
double minimum, maximum;
double[] array = new double[arraySize];

FillArray(array);
MinMax(array, out minimum, out maximum);

Console.WriteLine();
Console.Write("Наш Массив:");
Console.WriteLine("[ " + String.Join(" | ", array)+ " ]");
Console.WriteLine();
Console.WriteLine($"Максимум: {maximum}");
Console.WriteLine($"Минимум: {minimum}");
Console.WriteLine($"Разница: {maximum} - {minimum} = {Math.Round(maximum - minimum, 2)}");
Console.WriteLine();
    
