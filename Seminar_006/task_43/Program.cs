// Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; 
// значения b1, k1, b2 и k2 задаются пользователем.
// b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
// y1 = k1*x + b1
// y2 = k2*x + b2
// k1*x+b1 = k2*x + b2
// k1*x -k2*x = b2 - b1
// x (k1 -k2) = b2 -b1
// x =(b2-b1)/(k1-k2)
// y = k1(b2-b1)/(k1-k2) + b1 или y = k2(b2-b1)/(k1-k2) + b2




double ChekInput(string arg)
    {
        bool checkNumbers = true;
        checkNumbers = double.TryParse(arg, out double coefficient);
        while (checkNumbers == false)
            {
                Console.WriteLine("Вы ввели не число!");
                Console.Write("Введите число: ");
                arg = Console.ReadLine();
                checkNumbers = double.TryParse(arg, out coefficient);
            }
        return coefficient;
    }




Console.Write("Введите коэффициент b1: ");
double b1 = ChekInput(Console.ReadLine());

Console.Write("Введите коэффициент k1: ");
double k1 = ChekInput(Console.ReadLine());

Console.Write("Введите коэффициент b2: ");
double b2 = ChekInput(Console.ReadLine());

Console.Write("Введите коэффициент k2: ");
double k2 = ChekInput(Console.ReadLine());

double x;
double y;

x = (b2-b1)/(k1-k2);
y = k2*(b2-b1)/(k1-k2) + b2; // или можно использовать это уравнение y = k1*(b2-b1)/(k1-k2) + b1;

Console.WriteLine($"Координаты точки пересечения прямых: ({x}, {y})");
