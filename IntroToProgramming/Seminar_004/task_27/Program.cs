// Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.
// 452 -> 11
// 82 -> 10
// 9012 -> 12

Console.Write("Введите число: ");
string? number = Console.ReadLine();
Console.WriteLine();
int sum = 0;


if (number[0] == '-')
    {
        int ifNegative = Convert.ToInt32(Convert.ToString(number[0]) + Convert.ToString(number[1]));
        for (int i =2; i < number.Length; i++)
            {
                sum = sum + Convert.ToInt32(Convert.ToString(number[i]));
            }
        sum = sum + ifNegative;
    }
else
    {
        for (int i =0; i < number.Length; i++)
            {
                sum = sum + Convert.ToInt32(Convert.ToString(number[i]));
            }
    }


Console.WriteLine(sum);