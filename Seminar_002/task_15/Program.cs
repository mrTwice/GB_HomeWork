// Задача 15: Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
// 6 -> да
// 7 -> да
// 1 -> нет

Console.Clear();
Console.Write("Введите номер дня недели: ");
int num = Convert.ToInt32(Console.ReadLine());

switch (num)
{
    case 1:
        Console.WriteLine("Будний день.");
        break;
    case 2:
        Console.WriteLine("Будний день.");
        break;
    case 3:
        Console.WriteLine("Будний день.");
        break;
    case 4:
        Console.WriteLine("Будний день.");
        break;
    case 5:
        Console.WriteLine("Будний день.");
        break;
    case 6:
        Console.WriteLine("Выходной.");
        break;
    case 7:
        Console.WriteLine("Выходной");
        break;
    default:
        Console.WriteLine("Дней в неделе не может быть меньше одного и больше семи!");
        break;
}