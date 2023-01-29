
// Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.
// 645 -> 5
// 78 -> третьей цифры нет
// 32679 -> 6

Console.Clear();

Console.WriteLine("Числовой метод".ToUpper());
Console.WriteLine();

Console.Write("Введите число: ");
int num = Math.Abs(Convert.ToInt32(Console.ReadLine()));
int numCount = num, thirdNum, index = 0, div = 1;


if (num < 100)
    {
        Console.WriteLine("ВНИМАНИЕ!!! Число двузначное, третьей цифры нет!");
    }
else
    {
    while ( numCount != 0)
        {
            numCount = numCount/10;
            index++;
    
        }

    for (int i=0; i<index-3; i++)
        {
            div = div*10;
        }
    thirdNum = (num/div)%10;
    Console.WriteLine($"Третья цифра в числе: {thirdNum}");
    }


Console.WriteLine();
Console.WriteLine("#######################################################");
Console.WriteLine();


Console.WriteLine("Решение через строковые переменные".ToUpper());
Console.WriteLine();

Console.Write("Введите число: ");
string inputStrings = Console.ReadLine();
int stringLenght = inputStrings.Length;

if (stringLenght < 3)
    {
        Console.WriteLine("ВНИМАНИЕ!!! Число двузначное, третьей цифры нет!");
    }
else if (inputStrings[0] == '-')
    {
        Console.WriteLine($"Третья цифра в числе: {inputStrings[3]}");
    }
else
    {
        Console.WriteLine($"Третья цифра в числе: {inputStrings[2]}");
    }

