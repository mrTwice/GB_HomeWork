// Написать программу, которая из имеющегося массива строк формирует 
// массив из строк, длина которых меньше либо равна 3 символа.
// Первоначальный массив можно ввести с клавиатуры, либо задать на старте
// выполнения алгоритма. При решении не рекомендуется пользоваться
// коллекциями, лучше обойтись исключительно массивами.

// ["hello", "2", "world", ".-)"] -> ["2", ":-)"]
// ["1234", "1567", "-2", "computer science"] -> ["-2"
// ["Russia", "Denmark", "Kazan"] -> []


Console.Clear();

bool checkInput = true;
Console.Write("Введите размер массива: ");
string? convertInput = Console.ReadLine();
checkInput = int.TryParse(convertInput, out int sizeFirstArray);
while (checkInput == false || sizeFirstArray <= 0) 
{
    Console.WriteLine("Вы ввели не число!");
    Console.WriteLine();
    Console.Write("Введите положительное число больше нуля: ");
    convertInput = Console.ReadLine();
    checkInput = int.TryParse(convertInput, out sizeFirstArray);

}

string[] firstArray= new string[sizeFirstArray];
int sizeSecondArray = 0;
for (int i = 0; i < sizeFirstArray; i++)
    {
        Console.Write($"Введите элемент массива {i}: ");
        firstArray[i] = Console.ReadLine();
        if (firstArray[i].Length <= 3) sizeSecondArray++;
    }



Console.WriteLine();
string[] secondArray = new string[sizeSecondArray];
int countIndexForSecondArray = 0;
for (int i = 0; i < sizeFirstArray; i++)
    {
        if (firstArray[i].Length <= 3)
            {
                secondArray[countIndexForSecondArray] = firstArray[i];
                countIndexForSecondArray++;
            }
    }

Console.WriteLine(String.Join(", ", firstArray));
Console.WriteLine(String.Join(", ", secondArray));