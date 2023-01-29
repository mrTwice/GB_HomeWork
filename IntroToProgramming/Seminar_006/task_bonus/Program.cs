// Дополнительная задача на рекурсию (необязательная)
// Напишите программу для подсчета количества цифр в числе с помощью рекурсии.
// 12345 -> 5


int  NumberCount(int arg)
{ 
    if (arg/10 !=0)
    {
        return 1 + NumberCount(arg/10);
    }
    else return 1;
  

}


Console.Write("Введите число: ");
int number = Convert.ToInt32(Console.ReadLine());
int n = NumberCount(number);
Console.WriteLine(n);