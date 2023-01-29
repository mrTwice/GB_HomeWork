// Задача 61. Вывести первые N строк треугольника Паскаля. 
//Сделать вывод в виде равнобедренного треугольника

// Треугольник Паскаля — форма записи биномиальных коэффициентов в виде бесконечной треугольной таблицы. 
// Элементы массива обозначаются C subscript n superscript k, где n — номер строки, k — порядковый номер элемента в строке. 
// Нумерацию строк начинают с нулевой, при этом нулевая строка — это вершина, то есть число 1. 
// Нумерацию чисел в строке также начинают с нуля и с левого края.

// n!/k!*(n-k)!

double Factorial(int n)
        {
            double i, result = 1;
            for (i = 1; i <= n; i++)result *= i;
            return result;
        }

Console.Clear();
Console.Write("Сколько строк показать: ");
int N = Convert.ToInt32(Console.ReadLine());
for (int i = 0; i < N; i++)
    {
        for (int indent = 0; indent <= (N - i); indent++) Console.Write(String.Format("{0,4}",""));
        for (int k = 0; k <= i; k++) Console.Write(String.Format("{0,8}", Factorial(i) / (Factorial(k) * Factorial(i - k)))); 
        Console.WriteLine();
        Console.WriteLine();
    }