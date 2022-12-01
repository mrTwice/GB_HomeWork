// Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.
// 0, 7, 8, -2, -2 -> 2
// 1, -7, 567, 89, 223-> 3

Console.Clear();
int positiveNumbersCount = 0;
bool checkNumbers = true;
string? toConvert;

Console.Write("Сколько числе вы хотите ввести: ");
toConvert = Console.ReadLine();
checkNumbers = int.TryParse(toConvert, out int outSize);

while (checkNumbers == false || outSize <= 0) 
{
    Console.WriteLine("Вы ввели не число!");
    Console.Write("Введите положительное число больше нуля: ");
    toConvert = Console.ReadLine();
    checkNumbers = int.TryParse(toConvert, out outSize);

} 

int[] inputNumber = new int[outSize];


for (int i = 0; i < outSize; i++)
    {
        Console.Clear();
        Console.Write("Введите число: ");
        toConvert = Console.ReadLine();
        checkNumbers = int.TryParse(toConvert, out int outNumbers);
        while (checkNumbers == false)
        {
            Console.WriteLine("Вы ввели не число!");
            Console.Write("Введите число: ");
            toConvert = Console.ReadLine();
            checkNumbers = int.TryParse(toConvert, out outNumbers);
        }
        inputNumber[i] = outNumbers;
    }

Console.Clear();
Console.WriteLine("Вы ввели следующие числа: ["+String.Join(", ", inputNumber)+ "]");

for (int i = 0; i < inputNumber.Length; i++)
    {
        if (inputNumber[i] > 0)
            {
                positiveNumbersCount++;
            }
    }

Console.WriteLine($"Количество числе больше нуля: {positiveNumbersCount}");