
// Задача 21
// Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.
// A (3,6,8); B (2,1,-7), -> 15.84
// A (7,-5, 0); B (1,-1,9) -> 11.53


// AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2
// Math.Sqrt(object)
// Math.Pow(args,2)
// Math.Round(a, 2)



Console.WriteLine("Введите координаты первой точки: ");
Console.Write("xA = ");
double xA = Convert.ToDouble(Console.ReadLine());
Console.Write("yA = ");
double yA = Convert.ToDouble(Console.ReadLine());
Console.Write("zA = ");
double zA = Convert.ToDouble(Console.ReadLine());

Console.WriteLine("Введите координаты второй точки: ");
Console.Write("xB = ");
double xB = Convert.ToDouble(Console.ReadLine());
Console.Write("yB = ");
double yB = Convert.ToDouble(Console.ReadLine());
Console.Write("zB = ");
double zB = Convert.ToDouble(Console.ReadLine());

double lenghtLine = Math.Round(Math.Sqrt(Math.Pow(xB - xA, 2) + Math.Pow(yB - yA, 2) + Math.Pow(zB - zA, 2)), 2);


Console.WriteLine($"Расстояние между точками = {lenghtLine}");