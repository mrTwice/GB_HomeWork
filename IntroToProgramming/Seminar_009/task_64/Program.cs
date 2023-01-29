// Все задачи решить с помощью рекурсии
// Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.
// N = 5 -> "5, 4, 3, 2, 1"
// N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"


void OutputIntegerNumbers(int n)
{
    if ( n == 0)
        {
            return;
        }
    Console.Write($"{n} ");
    OutputIntegerNumbers(n-1);
}

Console.Clear();
Console.Write("Введите число N: ");
int N = Convert.ToInt32(Console.ReadLine());
OutputIntegerNumbers(N);