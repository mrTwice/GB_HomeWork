// Задача 19
// Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.
// 14212 -> нет
// 12821 -> да
// 23432 -> да

Console.Clear();
Console.Write("Введите пятизначное число число: ");
int number = Math.Abs(Convert.ToInt32(Console.ReadLine())),
             numCount = number, index = 0, remainders;
bool palindrome = true;

Console.WriteLine("");

if (number <10000 && number > 99999) // Проверка является ли число пятизначным.
{
    Console.Write("Введите пятизначное число число!");
}
else
{
    while ( numCount != 0) // Подсчет количества цифр в числе.
        {
            numCount = numCount/10;
            index++;
        }

    int[] numsArray = new int[index]; // Объявление массива, в который будет записано наше число.
    
    for (int i = 0; i < index; i++ ) // Запись значений в массив.
        {
            remainders = number%10;
            numsArray[(index-1)-i] = remainders;        
            number = number/10;
        }
    
    for (int i = 0; i < numsArray.Length/2; i++) // Проверка на палиндромность.
    {
        if (numsArray[i] != numsArray[(numsArray.Length-1) - i])
            {
                palindrome = false;
            }
    }

    if (palindrome == true) // Вывод результата в консоль.
        {
            Console.WriteLine("Введенное число - палиндром.");
        }
    else 
        {
            Console.WriteLine("Введенное число палиндромом не является.");
        }
    

}