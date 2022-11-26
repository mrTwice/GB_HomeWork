// Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.
// 3, 5 -> 243 (3⁵)
// 2, 4 -> 16

Console.Write("Введите основне степени: ");
int number = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

Console.Write("Введите показатель степени: ");
int exponentiate = Convert.ToInt32(Console.ReadLine());
Console.WriteLine();

int degree = number;

if (exponentiate == 0)
    {
        degree = 1;
    }
else
{
    for (int i = 1; i < exponentiate; i++)
    {
        degree = degree*number;
    }
}


Console.WriteLine($"{number} в степени {exponentiate} = {degree}");