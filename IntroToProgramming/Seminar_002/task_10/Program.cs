// Задача 10: Напишите программу, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа.
// 456 -> 5
// 782 -> 8
// 918 -> 1

Console.Clear();
Console.Write("Введите трехзначное число: ");
int num = Convert.ToInt32(Console.ReadLine());

if (num < 100 || num > 999)
{
    Console.WriteLine("ВНИМАНИЕ!!! Введите ТЕХЗНАЧНОЕ число: ");
}
else
{
    int secondNum = (num%100)/10;
    Console.WriteLine($"Искомое число: {secondNum} ");
}